package br.com.futbid.swing.ui.panel.option;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.annotation.PostConstruct;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public class BaseOption extends JPanel {

    
    @PostConstruct
    public void init() {
	Label label = new Label("WE ARE WORKING TO FINSH SOON", Alignment.CENTER.ordinal());
	label.setFont(new Font("Arial", 2, 26));
	label.setForeground(Color.RED);
	add(label);
    }
}
