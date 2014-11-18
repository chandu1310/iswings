package com.atlantis.core;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JPanel summaryPanel;
	private final JPanel cardsDisplayPanel;
	private final Map<String, JPanel> cards = new HashMap<String, JPanel>();
	private String currentCard = null;

	public CardsPanel() {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		summaryPanel = new JPanel();
		summaryPanel.setBackground(Color.WHITE);
		cardsDisplayPanel = new JPanel();
		cardsDisplayPanel.setBackground(Color.WHITE);
		cardsDisplayPanel.setPreferredSize(new Dimension(summaryPanel
				.getPreferredSize().width, 0));
		setBackground(Color.WHITE);
		add(summaryPanel);
		add(cardsDisplayPanel);
	}

	public JPanel getSummaryPanel() {
		return this.summaryPanel;
	}

	public JPanel addCard(String cardName) {
		JPanel card = new JPanel();
		card.setBorder(BorderFactory.createTitledBorder(cardName));
		cards.put(cardName, card);
		return card;
	}

	public void toggleCard(String cardName) {
		if (currentCard != null) {
			if (cardName.equals(currentCard))
				hideCard(currentCard);
			else
				showCard(cardName);
		} else
			showCard(cardName);
	}

	private void showCard(String cardName) {
		JPanel card = cards.get(cardName);
		if (card != null) {
			Container co = getParent();
			while (co != null && !(co instanceof JFrame))
				co = co.getParent();
			final JFrame _f = (JFrame) co;

			final Dimension targetSize = new Dimension(
					summaryPanel.getPreferredSize().width,
					card.getPreferredSize().height);

			cardsDisplayPanel.removeAll();
			FlowLayout fl = new FlowLayout();
			fl.setVgap(0);
			cardsDisplayPanel.setLayout(fl);
			card.setBackground(Color.WHITE);
			cardsDisplayPanel.setPreferredSize(targetSize);

			card.setPreferredSize(new Dimension(targetSize.width - 20, targetSize.height - 10));
			cardsDisplayPanel.add(card);
			_f.pack();
			currentCard = cardName;
		}
	}

	private void hideCard(String cardName) {
		Container co = getParent();
		while (co != null && !(co instanceof JFrame))
			co = co.getParent();
		final JFrame _f = (JFrame) co;
		cardsDisplayPanel.removeAll();
		cardsDisplayPanel.setPreferredSize(new Dimension(summaryPanel
				.getPreferredSize().width, 0));
		validate();
		repaint();
		_f.pack();
		currentCard = null;
	}

	public Dimension calculateProgress(Dimension startSize,
			Dimension targetSize, double progress) {

		Dimension size = new Dimension();

		if (startSize != null && targetSize != null) {

			size.width = calculateProgress(startSize.width, targetSize.width,
					progress);
			size.height = calculateProgress(startSize.height,
					targetSize.height, progress);

		}
		return size;
	}

	public int calculateProgress(int startValue, int endValue, double fraction) {

		int value = 0;
		int distance = endValue - startValue;
		value = (int) Math.round((double) distance * fraction);
		value += startValue;

		return value;
	}
}
