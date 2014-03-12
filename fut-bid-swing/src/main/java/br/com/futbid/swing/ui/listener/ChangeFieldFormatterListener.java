package br.com.futbid.swing.ui.listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;

public class ChangeFieldFormatterListener implements PropertyChangeListener {

    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    
    @Override
    public void propertyChange(PropertyChangeEvent event) {

	Object source = event.getSource();
 	if (source instanceof JFormattedTextField) {
	    Object value = ((JFormattedTextField) source).getValue();
	    if (value != null) {
		((JFormattedTextField) source).setText(NumberFormat.getInstance().format(value));
	    }
	}
	//System.out.println(source);

    }

}
