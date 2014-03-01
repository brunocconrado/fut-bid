package br.com.futbid.swing.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelFactory {

    public static JLabel createLable(String title, Color backgroundColor) {
	return createLable(title, backgroundColor, null, null);
    }

    public static JLabel createLable(String title, Color backgroundColor, Color foreground) {
	return createLable(title, backgroundColor, foreground, new Font("Arial", 1, 12));
    }

    public static JLabel createLable(String title, Color backgroundColor, Color foreground, Font font) {
	JLabel label = new JLabel(title);
	label.setBackground(backgroundColor);
	if (foreground != null) {
	    label.setForeground(foreground);
	}
	if (font != null) {
	    label.setFont(font);
	}
	return label;
    }

}
