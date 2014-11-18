package com.atlantis.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.atlantis.core.CardsPanel;
import com.atlantis.core.GUIBuilder;

public class AtlantisUIBuilder implements GUIBuilder, UIConstants {
	GUIMediator mediator = GUIMediator.getInstance();

	@Override
	public void buildUI(Container co) {
		co.setBackground(Color.WHITE);
		co.setForeground(Color.BLACK);
		co.setLayout(new BorderLayout());

		final CardsPanel cards = new CardsPanel();
		mediator.registerCardsPanel(cards);
		JPanel summaryPanel = cards.getSummaryPanel();
		summaryPanel.setPreferredSize(new Dimension(550, 60));
		JPanel tmCard = cards.addCard(UIConstants.TM_CARD);
		{
			tmCard.setPreferredSize(new Dimension(50, 400));
			tmCard.add(new JLabel("TM"));
		}
		JPanel asCard = cards.addCard(UIConstants.AS_CARD);
		{
			asCard.setPreferredSize(new Dimension(200, 200));
			asCard.add(new JLabel("AS"));
		}
		JPanel bsCard = cards.addCard(UIConstants.BS_CARD);
		{
			bsCard.setPreferredSize(new Dimension(100, 300));
			bsCard.add(new JLabel("BS"));
		}

		JLabel startAllLbl = new JLabel(new ImageIcon(START_ALL)), stopAllLbl = new JLabel(
				new ImageIcon(STOP_ALL)), restartAllLbl = new JLabel(
				new ImageIcon(RESTART_ALL)), tradeMonitorStatusLbl = new JLabel(
				new ImageIcon(MODULE_UP)), appServerStatusLbl = new JLabel(
				new ImageIcon(MODULE_STARTING)), basketServerStatusLbl = new JLabel(
				new ImageIcon(MODULE_DOWN));
		mediator.registerStartAllLbl(startAllLbl);
		mediator.registerStopAllLbl(stopAllLbl);
		mediator.registerRestartAllLbl(restartAllLbl);
		mediator.registerTradeMonitorStatusLbl(tradeMonitorStatusLbl);
		mediator.registerAppServerStatusLbl(appServerStatusLbl);
		mediator.registerBasketServerStatusLbl(basketServerStatusLbl);

		JCheckBox includeTM = new JCheckBox(), includeAS = new JCheckBox(), includeBS = new JCheckBox();
		mediator.registerIncludeTM(includeTM);
		mediator.registerIncludeAS(includeAS);
		mediator.registerIncludeBS(includeBS);

		summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.LINE_AXIS));
		summaryPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		summaryPanel.add(startAllLbl);
		summaryPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		summaryPanel.add(stopAllLbl);
		summaryPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		summaryPanel.add(restartAllLbl);

		summaryPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		JPanel ckbox_p1 = new JPanel();
		ckbox_p1.setBackground(Color.WHITE);
		ckbox_p1.setMaximumSize(new Dimension(40, 60));
		includeTM.setSelected(true);
		includeTM.setBackground(Color.WHITE);
		ckbox_p1.add(includeTM);
		summaryPanel.add(ckbox_p1);
		tradeMonitorStatusLbl.setToolTipText(UIConstants.TM_CARD);
		tradeMonitorStatusLbl.setVerticalAlignment(JLabel.TOP);
		tradeMonitorStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		summaryPanel.add(tradeMonitorStatusLbl);

		summaryPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		JPanel ckbox_p2 = new JPanel();
		ckbox_p2.setBackground(Color.WHITE);
		ckbox_p2.setMaximumSize(new Dimension(40, 60));
		includeAS.setSelected(true);
		includeAS.setBackground(Color.WHITE);
		ckbox_p2.add(includeAS);
		summaryPanel.add(ckbox_p2);
		appServerStatusLbl.setToolTipText(UIConstants.AS_CARD);
		appServerStatusLbl.setVerticalAlignment(JLabel.TOP);
		appServerStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		summaryPanel.add(appServerStatusLbl);

		summaryPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		JPanel ckbox_p3 = new JPanel();
		ckbox_p3.setBackground(Color.WHITE);
		ckbox_p3.setMaximumSize(new Dimension(40, 60));
		includeBS.setSelected(true);
		includeBS.setBackground(Color.WHITE);
		ckbox_p3.add(includeBS);
		summaryPanel.add(ckbox_p3);
		basketServerStatusLbl.setToolTipText(UIConstants.BS_CARD);
		basketServerStatusLbl.setVerticalAlignment(JLabel.TOP);
		basketServerStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		summaryPanel.add(basketServerStatusLbl);
		
		co.add(cards, BorderLayout.NORTH);
	}

	public static String transformStringToHtml(String strToTransform) {
		String ans = "<html>";
		String br = "<br>";
		String[] lettersArr = strToTransform.split("");
		for (String letter : lettersArr) {
			ans += letter + br;
		}
		ans += "</html>";
		return ans;
	}
}
