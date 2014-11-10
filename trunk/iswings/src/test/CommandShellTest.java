package test;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CommandShellTest {
	Executor exec = Executors.newSingleThreadExecutor();
	JComboBox events;
	JTextField winid, id, params;
	public CommandShellTest() {
		JFrame frame = new JFrame("CommandShellTest");
		Container co = frame.getContentPane();
		co.setLayout(new GridLayout(5,2));

		co.add(new JLabel("WINID"));
		winid = new JTextField("JIXTESTFRAME");
		co.add(winid);

		co.add(new JLabel("ID"));
		id = new JTextField("TESTBUTTON");
		co.add(id);
		
		co.add(new JLabel("Event"));
		events = new JComboBox(new String[]{"MOUSE","TEXT","DRAG","WINDOW","ACTION"});
		co.add(events);
		
		co.add(new JLabel("Params"));
		params = new JTextField("1");
		co.add(params);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				events.setSelectedIndex(0);
				params.setText("");
			}
		});
		co.add(clear);
		JButton ok = new JButton("Send");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exec.execute(new Runnable() {
					@Override
					public void run() {
						//Send a data message to command shell
						//ID##EVENT##PARAMS
						String message = winid.getText()
						+"~"
						+id.getText()
						+"##"
						+events.getSelectedIndex()
						+"##"
						+params.getText();
						sendCommand(message);
					}
				});
			}
		});
		co.add(ok);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setVisible(true);
	}
	
	public void sendCommand(String commandString) {
		try {
			sendCommand(InetAddress.getByName("localhost"), 9876,
					commandString);
		} catch (Exception er) {
			System.out
					.println("CommandShell: Unable to fetch InetAddress of localhost.");
			er.printStackTrace();
		}
	}

	public void sendCommand(InetAddress inetAddress, int port,
			String commandString) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			byte[] sendData = new byte[1024];
			sendData = commandString.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, inetAddress, port);
			clientSocket.send(sendPacket);
			clientSocket.close();
		} catch (Exception er) {
			System.out
					.println("CommandShell: Unable to process command string: "
							+ commandString);
			er.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CommandShellTest();
	}
}
