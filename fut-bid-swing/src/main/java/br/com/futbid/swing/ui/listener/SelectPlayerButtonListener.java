package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.springframework.stereotype.Component;

import br.com.futbid.swing.ui.panel.option.Dialog;

@Component
public class SelectPlayerButtonListener implements ActionListener {

    private Dialog parent;

    @Override
    public void actionPerformed(ActionEvent event) {
	JButton button = (JButton) event.getSource();
	Dialog dialog = (Dialog) button.getParent().getParent().getParent();
	dialog.getDialog().setVisible(true);
	((Dialog)dialog.getDialog()).setParent(parent);
    }

    public void setParent(Dialog parent) {
	this.parent = parent;
    }

}
