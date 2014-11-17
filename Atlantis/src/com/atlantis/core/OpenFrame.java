package com.atlantis.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public final class OpenFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private int _posX = 0, _posY = 0;
	private InnerPane newContentPane = new InnerPane();

	public OpenFrame(String title) {
		super();
		setName(title);
		setUndecorated(true);
		newContentPane.setOpaque(true);
		setContentPane(newContentPane);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				_posX = e.getX();
				_posY = e.getY();
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent evt) {
				// sets frame position when mouse dragged
				setLocation(evt.getXOnScreen() - _posX, evt.getYOnScreen()
						- _posY);
			}
		});
	}

	@Override
	public Container getContentPane() {
		return newContentPane.getContentPane();
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
		newContentPane.positionMinimizeButton();
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		validate();
	}
	
	private class InnerPane extends JPanel {
		private static final long serialVersionUID = 1L;
		private int ICON_WIDTH = 20, ICON_HEIGHT = 20;
		private Icon MINIMIZE_ICON = new ImageIcon("resources/images/base/min.png");
		private JLayeredPane layeredPane = new JLayeredPane();
		private JPanel contentPane = new JPanel();
		private JButton minimizeLabel = createMinimizeButton();

		public InnerPane() {
			super();
			layeredPane.add(contentPane, new Integer(0));
			layeredPane.add(minimizeLabel, new Integer(10));
			setLayout(new BorderLayout());
			add(layeredPane, BorderLayout.CENTER);
		}

		public JPanel getContentPane() {
			return this.contentPane;
		}

		public void positionMinimizeButton() {
			contentPane.setBounds(0, 0, getParent().getWidth(), getParent()
					.getHeight());

			minimizeLabel.setBounds(getParent().getWidth() - ICON_WIDTH, 0,
					ICON_WIDTH, ICON_HEIGHT);
		}

		private JButton createMinimizeButton() {
			JButton button = new JButton(MINIMIZE_ICON);
			button.setVerticalAlignment(JButton.TOP);
			button.setHorizontalAlignment(JButton.CENTER);
			button.setOpaque(true);
			button.setBackground(Color.WHITE);
			button.setForeground(Color.WHITE);
			button.setBorder(BorderFactory.createEmptyBorder());
			button.setContentAreaFilled(false);
			button.setBounds(0, 0, 20, 20);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Container co = getParent();
					while (co != null && !(co instanceof JFrame))
						co = co.getParent();
					JFrame _f = (JFrame) co;
					WindowListener[] _l = _f.getWindowListeners();
					if (_l != null && _l.length != 0) {
						_f.dispatchEvent(new WindowEvent(_f,
								WindowEvent.WINDOW_CLOSING));
					}
				}
			});
			return button;
		}
	}
}
