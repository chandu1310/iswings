package com.atlantis.gui;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Container;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.atlantis.core.GUIBuilder;

public class AppWindow {
	private static AppWindow classInstance = new AppWindow();
	JFrame frame = null;
	private int _posX = 0, _posY = 0;

	private AppWindow() {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				/* Use an appropriate Look and Feel */
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				} catch (IllegalAccessException ex) {
					ex.printStackTrace();
				} catch (InstantiationException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
				/* Turn off metal's use of bold fonts */
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				// Schedule a job for the event-dispatching thread:
				// adding TrayIcon.

				initializeSystemTrayUI();

				frame = new JFrame("PW Launcher");
				GUIMediator.getInstance().registerFrame(frame);

				frame.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						_posX = e.getX();
						_posY = e.getY();
					}
				});

				frame.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						// sets frame position when mouse dragged
						frame.setLocation(evt.getXOnScreen() - _posX,
								evt.getYOnScreen() - _posY);
					}
				});
				frame.setUndecorated(true);
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});

				Container co = frame.getContentPane();

				GUIBuilder builder = new AtlantisUIBuilder();
				builder.buildUI(co);

				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private static void initializeSystemTrayUI() {
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
			return;
		}

		GUIMediator mediator = GUIMediator.getInstance();

		final TrayIcon trayIcon = new TrayIcon(new ImageIcon(
				"resources/images/base/tray_icon.png").getImage());
		mediator.registerTrayIcon(trayIcon);
		final SystemTray tray = SystemTray.getSystemTray();

		final PopupMenu popup = new PopupMenu();
		MenuItem aboutItem = new MenuItem("About");
		CheckboxMenuItem showLauncherMenuItem = new CheckboxMenuItem(
				"Show Launcher");
		MenuItem exitItem = new MenuItem("Exit");
		mediator.registerAboutItem(aboutItem);
		mediator.registerShowLauncherItem(showLauncherMenuItem);
		mediator.registerExitItem(exitItem);

		// Add components to popup menu
		popup.add(aboutItem);
		popup.addSeparator();
		popup.add(showLauncherMenuItem);
		popup.addSeparator();
		popup.add(exitItem);

		trayIcon.setPopupMenu(popup);

		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
			return;
		}

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuItem item = (MenuItem) e.getSource();
				// TrayIcon.MessageType type = null;
				System.out.println(item.getLabel());
				if ("Error".equals(item.getLabel())) {
					// type = TrayIcon.MessageType.ERROR;
					trayIcon.displayMessage("Sun TrayIcon Demo",
							"This is an error message",
							TrayIcon.MessageType.ERROR);

				} else if ("Warning".equals(item.getLabel())) {
					// type = TrayIcon.MessageType.WARNING;
					trayIcon.displayMessage("Sun TrayIcon Demo",
							"This is a warning message",
							TrayIcon.MessageType.WARNING);

				} else if ("Info".equals(item.getLabel())) {
					// type = TrayIcon.MessageType.INFO;
					trayIcon.displayMessage("Sun TrayIcon Demo",
							"This is an info message",
							TrayIcon.MessageType.INFO);

				} else if ("None".equals(item.getLabel())) {
					// type = TrayIcon.MessageType.NONE;
					trayIcon.displayMessage("Sun TrayIcon Demo",
							"This is an ordinary message",
							TrayIcon.MessageType.NONE);
				}
			}
		};
	}

	public static AppWindow getInstance() {
		return classInstance;
	}

	public void showApp(boolean flag) {
		if (frame != null)
			frame.setVisible(flag);
	}
}
