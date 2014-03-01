package br.com.futbid.swing.ui.painel.auth;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.futbid.swing.ui.listener.AuthActionListener;
import br.com.futbid.swing.ui.utils.Colors;

public abstract class AuthenticationPainel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField answerField;

    public AuthenticationPainel() {
	bildUI();
    }

    private void bildUI() {
	setBackground(Colors.BACK_GROUND);
	setLayout(new BorderLayout());
	setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	JLabel label = new JLabel("Please provide your FUT credentials: ");
	label.setBackground(Colors.BACK_GROUND);
	label.setForeground(Colors.HEADER_COLOR);
	label.setFont(new Font("Arial", 1, 14));

	JPanel centerContainer = new JPanel(new BorderLayout());

	JPanel fieldPanel = new JPanel();
	fieldPanel.setBackground(Colors.BACK_GROUND);
	GridLayout layout = new GridLayout(3, 2);
	layout.setVgap(30);
	fieldPanel.setLayout(layout);
	fieldPanel.setPreferredSize(new Dimension(0, 130));

	JLabel email = new JLabel("Email");
	email.setBackground(Colors.BACK_GROUND);
	fieldPanel.add(email);

	fieldPanel.add(this.emailField = new JTextField());

	JLabel password = new JLabel("Password");
	password.setBackground(Colors.BACK_GROUND);
	fieldPanel.add(password);

	fieldPanel.add(this.passwordField = new JTextField());

	JLabel answer = new JLabel("Answer");
	answer.setBackground(Colors.BACK_GROUND);
	fieldPanel.add(answer);

	this.answerField = new JTextField();
	fieldPanel.add(answerField);

	JPanel controllPanel = new JPanel(new FlowLayout(2));
	controllPanel.setBackground(Colors.BACK_GROUND);

	JButton loginButton = new JButton("Login");
	loginButton.addActionListener(new AuthActionListener());
	controllPanel.add(loginButton);

	centerContainer.add(fieldPanel, "North");
	centerContainer.add(controllPanel, "Center");

	add(label, "North");
	add(centerContainer, "Center");
	/*
	 * if (ApplicationParametersManager.INSTANCE().getLicense() != null) {
	 * this.emailField.setText(ApplicationParametersManager.INSTANCE().getLicense().getEmail());
	 * this.emailField.setEditable(false); }
	 */
    }

    public abstract void showAudobuyerPanel();

    public void clearData() {
	/*
	 * if (ApplicationParametersManager.INSTANCE().getLicense() == null) { this.emailField.setText(""); }
	 * this.passwordField.setText(""); this.answerField.setText("");
	 */
    }

}
