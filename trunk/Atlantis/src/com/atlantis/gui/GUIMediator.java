package com.atlantis.gui;

import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.atlantis.AtlantisContext;
import com.atlantis.core.CardsPanel;
import com.atlantis.model.ModelConstants.ServerStatus;

public class GUIMediator {
	private GUIMediator(){};
	private static final GUIMediator classInstance = new GUIMediator();
	public static GUIMediator getInstance(){
		return classInstance;
	}
	
	private TrayIcon trayIcon; 
	private CheckboxMenuItem showLauncherItem;
	private MenuItem aboutItem, exitItem;
	private JFrame frame;
	private JLabel startAllLbl, stopAllLbl, restartAllLbl,
			tradeMonitorStatusLbl, appServerStatusLbl, basketServerStatusLbl;

	private JCheckBox includeTM, includeAS, includeBS;

	private CardsPanel cards;
	
	private final Color ON_ENTER = Color.ORANGE, ON_EXIT = Color.WHITE, ON_PRESSED = Color.WHITE, ON_RELEASE = Color.ORANGE;
	
	public void registerCardsPanel(CardsPanel cards){
		this.cards = cards;
	}
	
	public void registerAboutItem(MenuItem aboutItem){
		this.aboutItem = aboutItem;
        this.aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "ATLANTIS - The launcher app for Portware.");
            }
        });         
	}
	
	public void registerShowLauncherItem(CheckboxMenuItem showLauncherItem){
		this.showLauncherItem = showLauncherItem;
		this.showLauncherItem.setState(true);
        this.showLauncherItem.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int cb1Id = e.getStateChange();
                if (cb1Id == ItemEvent.SELECTED){
                    AppWindow.getInstance().showApp(true);
                } else {
                	AppWindow.getInstance().showApp(false);
                }
            }
        });
	}
	
	public void registerExitItem(MenuItem exitItem){
		this.exitItem = exitItem;
        this.exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SystemTray.getSystemTray().remove(trayIcon);
                System.exit(0);
            }
        });
	}
	
	public void registerTrayIcon(TrayIcon trayIcon){
		this.trayIcon = trayIcon;
        this.trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	showLauncherItem.setState(true);
            	AppWindow.getInstance().showApp(true);
            }
        });
        this.trayIcon.setToolTip(UIConstants.APP_TITLE);
	}
	
	public void registerFrame(JFrame frame){
		this.frame = frame;
		this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/base/tray_icon.png"));
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				showLauncherItem.setState(false);
				AppWindow.getInstance().showApp(false);
			}
		});
	}
	
	public void registerStartAllLbl(JLabel startAllLbl) {
		this.startAllLbl = startAllLbl;
		startAllLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_ENTER));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_EXIT));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("Clicked");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_PRESSED));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_RELEASE));
			}
		});
		startAllLbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public void registerStopAllLbl(JLabel stopAllLbl) {
		this.stopAllLbl = stopAllLbl;
		this.stopAllLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_ENTER));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_EXIT));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("Clicked");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_PRESSED));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_RELEASE));
			}
		});
		stopAllLbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public void registerRestartAllLbl(JLabel restartAllLbl) {
		this.restartAllLbl = restartAllLbl;
		this.restartAllLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_ENTER));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_EXIT));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("Clicked");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_PRESSED));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_RELEASE));
			}
		});
		restartAllLbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public void registerTradeMonitorStatusLbl(JLabel tradeMonitorStatusLbl) {
		this.tradeMonitorStatusLbl = tradeMonitorStatusLbl;
		this.tradeMonitorStatusLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_ENTER));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_EXIT));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				cards.toggleCard(UIConstants.TM_CARD);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_PRESSED));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_RELEASE));
			}
		});
		tradeMonitorStatusLbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public void registerAppServerStatusLbl(JLabel appServerStatusLbl) {
		this.appServerStatusLbl = appServerStatusLbl;
		this.appServerStatusLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_ENTER));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_EXIT));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				cards.toggleCard(UIConstants.AS_CARD);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_PRESSED));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_RELEASE));
			}
		});
		appServerStatusLbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public void registerBasketServerStatusLbl(JLabel basketServerStatusLbl) {
		this.basketServerStatusLbl = basketServerStatusLbl;
		this.basketServerStatusLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_ENTER));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_EXIT));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				cards.toggleCard(UIConstants.BS_CARD);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_PRESSED));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(ON_RELEASE));
			}
		});
		basketServerStatusLbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public void registerIncludeTM(JCheckBox includeTM) {
		this.includeTM = includeTM;
	}

	public void registerIncludeAS(JCheckBox includeAS) {
		this.includeAS = includeAS;
	}

	public void registerIncludeBS(JCheckBox includeBS) {
		this.includeBS = includeBS;
	}
	
	
	//Data binding
	public void refreshTradeMonitorStatus(){
		
	}
	
	public void refreshBasketServerStatus(){
		
	}
	
	public void refreshAppServerStatus(){
		
	}
	
	public void refreshServerStatus(){
		refreshTradeMonitorStatus();
		refreshAppServerStatus();
		refreshTradeMonitorStatus();
	}	
	
	public void refreshAll(){
		refreshAll();

		int result = 0; // System Down
		
		if(AtlantisContext.TM_INFO.getStatus()==ServerStatus.SERVER_UP 
				&& AtlantisContext.AS_INFO.getStatus()==ServerStatus.SERVER_UP
				&& AtlantisContext.BS_INFO.getStatus()==ServerStatus.SERVER_UP){
			result = 1; // success
		}else if(AtlantisContext.TM_INFO.getStatus()==ServerStatus.SERVER_FAILED 
				|| AtlantisContext.AS_INFO.getStatus()==ServerStatus.SERVER_FAILED
				|| AtlantisContext.BS_INFO.getStatus()==ServerStatus.SERVER_FAILED){
			result = -1; //failed
		}else if(AtlantisContext.TM_INFO.getStatus()==ServerStatus.SERVER_STARTING 
				|| AtlantisContext.AS_INFO.getStatus()==ServerStatus.SERVER_STARTING
				|| AtlantisContext.BS_INFO.getStatus()==ServerStatus.SERVER_STARTING){
			result = 2; //Still starting
		}
			
		switch (result) {
		case 1:
			//successfully started all modules
			startAllLbl.setIcon(new ImageIcon(UIConstants.STARTED_ALL));
			break;
		case 2:			
			// modules are starting up
			startAllLbl.setIcon(new ImageIcon(UIConstants.STARTING_ALL));
			break;
		case -1:			
			// One or more modules didnot start.
			startAllLbl.setIcon(new ImageIcon(UIConstants.FAILED_TO_START_ALL));
			break;
		case 0:			
			// All or some of the modules are down.
			startAllLbl.setIcon(new ImageIcon(UIConstants.START_ALL));
			break;
		default:
			//default state
			startAllLbl.setIcon(new ImageIcon(UIConstants.START_ALL));
			break;
		}
		//refresh main controls.
	}
}
