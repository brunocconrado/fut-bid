package br.com.futbid.swing.ui.panel.auth.impl;

import static br.com.futbid.swing.ui.LabelFactory.createLable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.swing.ui.listener.AuthActionListener;
import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.tab.WorkTabPanel;
import br.com.futbid.swing.ui.utils.Colors;

public class AuthenticationPainelImpl extends JPanel implements AuthenticationPainel {

    private static final long serialVersionUID = 2014030601L;

    private JTextField emailField;
    private JTextField passwordField;
    private JTextField answerField;

    private WorkTabPanel workTabPanel;

    public AuthenticationPainelImpl() {

	setBackground(Colors.BACK_GROUND);
	setLayout(new BorderLayout());
	setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	GridLayout layout = new GridLayout(3, 2);
	layout.setVgap(30);

	JPanel fieldPanel = new JPanel();
	fieldPanel.setBackground(Colors.BACK_GROUND);
	fieldPanel.setLayout(layout);
	fieldPanel.setPreferredSize(new Dimension(50, 130));

	fieldPanel.add(createLable("Email: ", Colors.BACK_GROUND));
	emailField = new JTextField();
	fieldPanel.add(emailField);

	fieldPanel.add(createLable("Password: ", Colors.BACK_GROUND));
	passwordField = new JTextField();
	fieldPanel.add(passwordField);

	fieldPanel.add(createLable("Answer: ", Colors.BACK_GROUND));
	answerField = new JTextField();
	fieldPanel.add(answerField);

	JButton loginButton = new JButton("Login");
	loginButton.addActionListener(new AuthActionListener());

	JPanel controllPanel = new JPanel(new FlowLayout(2));
	controllPanel.setBackground(Colors.BACK_GROUND);
	controllPanel.add(loginButton);

	JPanel centerContainer = new JPanel(new BorderLayout());
	centerContainer.add(fieldPanel, "North");
	centerContainer.add(controllPanel, "Center");

	add(createLable("Please provide your FUT credentials: ", Colors.BACK_GROUND, Colors.HEADER_COLOR, new Font(
		"Arial", 1, 14)), "North");
	add(centerContainer, "Center");
    }

    @Override
    public void setWorkPanel(WorkTabPanel workTabPanel) {
	this.workTabPanel = workTabPanel;
    }

    @Override
    public void clearFields() {
	//	if (ApplicationParametersManager.INSTANCE().getLicense() == null) {
	this.emailField.setText("");
	//	}
	this.passwordField.setText("");
	this.answerField.setText("");

    }

    @Override
    public void showAutoBuyerPanel() {
	workTabPanel.showAutoBuyerPanel();
    }

    @Override
    public Credentials getCredentials() {
	Credentials credentials = new Credentials();
	/*credentials.setLogin(emailField.getText());
	credentials.setPassword(passwordField.getText());
	credentials.setSecretAnswer(answerField.getText());*/
	credentials.setLogin("bruno_csantos@hotmail.com");
	credentials.setPassword("xxx");
	credentials.setSecretAnswer("xxx");
	return credentials;
    }

}
