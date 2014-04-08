package br.com.futbid.swing.ui.utils;

import javax.swing.JOptionPane;

public class DialogMessageUtil {
    
    private DialogMessageUtil() {
	throw new UnsupportedOperationException();
    }

    public static void showErrorMessage(String message) {
	JOptionPane.showMessageDialog(null, message, "Error", 0);
    }

    public static void showInformationMessage(String message) {
	JOptionPane.showMessageDialog(null, message, "Information", 1);
    }

    public static void showWarningMessage(String message) {
	JOptionPane.showMessageDialog(null, message, "Warning", 2);
    }
}