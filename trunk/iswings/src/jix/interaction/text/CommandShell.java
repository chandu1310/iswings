package jix.interaction.text;

import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * This class listens to the incoming shell commands and passes it on to the EventDispatcher.
 */
public class CommandShell implements Runnable {
	public static final int SERVER_NOTSTARTED = 0;
	public static final int SERVER_FAILED = -1;
	public static final int SERVER_STARTED = 1;
	public static int SHELL_PORT = 9876;
	public static int MAX_COMMAND_PACKET_SIZE = 1024;

	private static final CommandShell obj = new CommandShell();
	private EventDispatcher ed = EventDispatcher.getInstance();
	private Executor exec = Executors.newSingleThreadExecutor();
	
	
	private Thread shellThread = null;
	private static int serverState = SERVER_NOTSTARTED;

	private CommandShell() {
		initialize();
	}

	public static CommandShell getInstance() {
		return obj;
	}

	public void initialize() {
		this.shellThread = new Thread(this);
		this.shellThread.start();
	}

	public static int edcount = 0;

	private void dispatchToCommandProcessor(final String commandString) {
		exec.execute( new Runnable() {
			@Override
			public void run() {
				ed.processCommand(commandString);
			}
		});
	}

	private void listenAndProcess(DatagramSocket serverSocket) {		
		while (true) {
			try {
				byte[] receiveData = new byte[MAX_COMMAND_PACKET_SIZE];
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				serverSocket.receive(receivePacket);
				String commandString = new String(receivePacket.getData());
				System.out.println("RECEIVED: " + commandString);
				dispatchToCommandProcessor(commandString);

				// InetAddress IPAddress = receivePacket.getAddress();
				// int port = receivePacket.getPort();
			} catch (Exception e) {
				serverSocket.close();
				System.err.println("CommandShell: Exception occured while processing command. Server is going down.");
				serverState = SERVER_FAILED;
				e.printStackTrace();
			}
		}
	}

	public void run() {
		try {
			DatagramSocket serverSocket = new DatagramSocket(SHELL_PORT);
			if (serverSocket.isBound()) {
				// This means that the port is free and server needs to run.
				// Start listening to incoming messages and process them.
				serverState = SERVER_STARTED;
				System.out.println("CommandShell: Command server started successully. Listening for incoming commands.");
				listenAndProcess(serverSocket);
			} else {
				// Serve is already running just don't do anything.
				serverState = SERVER_STARTED;
				return;
			}
		}
		catch(BindException er){
			if("Address already in use".equals(er.getMessage())){
				System.err.println("CommandShell: Server already started.");
				serverState = SERVER_STARTED;
			}else{
				serverState = SERVER_FAILED;
				System.err.println("CommandShell: Unable to bind the command server to shell port.");				
			}
			return;
		}
		catch (Exception er) {
			serverState = SERVER_FAILED;
			System.err.println("CommandShell: Unable to start the command server.");
		}
	}
	
	public static void main(String[] args) {
		CommandShell.getInstance();
	}
}
