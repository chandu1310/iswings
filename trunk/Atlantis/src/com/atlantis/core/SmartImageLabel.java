package com.atlantis.core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class SmartImageLabel extends JComponent {
	    private Image image;
	    private double scale;

	    public SmartImageLabel(ImageIcon icon, double scale) {
	        image = icon.getImage();
	        this.scale = scale;
	    }

	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Insets insets = getInsets();
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.translate(insets.left, insets.top);
	        g2.scale(scale, scale);
	        g2.drawImage(image, 0, 0, this);
	        g2.dispose();
	    }

	    public Dimension getPreferredSize() {
	        Insets insets = getInsets();
	        int w = insets.left + insets.right + (int)(scale*image.getWidth(null));
	        int h = insets.top + insets.bottom + (int)(scale*image.getHeight(null));
	        return new Dimension(w,h);
	    }
}
