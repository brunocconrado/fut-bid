package br.com.futbid.swing.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelFactory {

    public static JLabel createLable(String title, Color backgroundColor) {
	return createLable(title, backgroundColor, null, null, false);
    }

    public static JLabel createLable(String title, Color backgroundColor, Dimension dimension,
	    Integer horizontalPosition, boolean ispreferredSize) {
	return createLable(title, backgroundColor, null, new Font("Arial", 1, 12), dimension, horizontalPosition, ispreferredSize);
    }

    public static JLabel createLable(String title, Color backgroundColor, Color foreground, Dimension dimension,
	    Integer horizontalPosition, boolean ispreferredSize) {
	return createLable(title, backgroundColor, foreground, new Font("Arial", 1, 12), dimension, horizontalPosition, ispreferredSize);
    }

    public static JLabel createLable(String title, Color backgroundColor, Color foreground, Font font,
	    Dimension dimension, Integer horizontalPosition, boolean ispreferredSize) {
	JLabel label = new JLabel(title);

	if (backgroundColor != null) {
	    label.setBackground(backgroundColor);
	}
	if (foreground != null) {
	    label.setForeground(foreground);
	}
	if (font != null) {
	    label.setFont(font);
	}
	if (dimension != null) {
	    if (ispreferredSize) {
		label.setPreferredSize(dimension);
	    } else {
		label.setSize(dimension);
	    }
	}

	return label;
    }

}
