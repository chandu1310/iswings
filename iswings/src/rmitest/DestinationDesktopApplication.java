package rmitest;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DestinationDesktopApplication extends JFrame implements DesktopApplicationInterface {
	private String appID = "";
	private final JFrame _mainFrame;
	private JButton _testButton;

	public DestinationDesktopApplication(String appID) {
		super(appID);
		this.appID = appID;
		this._mainFrame = this;
		initComponents();
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initComponents(){
		Container co = getContentPane();
		co.setLayout(new FlowLayout());
		_testButton = new JButton("Test Button");
		_testButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(_mainFrame, "Clicked the button!");
			}
		}); 
		co.add(_testButton);
	}
	
	public String getAppID(){
		return this.appID;
	}
	
	@Override
	public String sayHello() throws RemoteException {
		try{
//		Method fireMethod = AbstractButton.class.getDeclaredMethod("fireActionPerformed", ActionEvent.class);
//		fireMethod.setAccessible(true);
		final ActionEvent ae = new ActionEvent(_testButton, ActionEvent.ACTION_PERFORMED, _testButton.getActionCommand());
//		fireMethod.invoke(_testButton, ae);
			for(final ActionListener l: _testButton.getActionListeners()){
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run() {
						l.actionPerformed(ae);		
					}
				});
				
			}
		}catch(Exception er){
			er.printStackTrace();
		}
		return "Hi! This is "+appID+". Time now is: "+Calendar.getInstance().getTime().toString();
	}

	public static void main(String args[]) {

		try {
			DestinationDesktopApplication obj = new DestinationDesktopApplication("CHANDU01");
			DesktopApplicationInterface stub = (DesktopApplicationInterface) UnicastRemoteObject
					.exportObject(obj, 0);

			Naming.rebind(obj.getAppID(), stub);
			System.out.println("Desktop application "+obj.getAppID()+" is ready to take commands.");
		} catch (Exception e) {
			System.out.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
