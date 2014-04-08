package br.com.futbid.swing.ui.panel.auth.impl;

import static br.com.futbid.swing.ui.LabelFactory.createLable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.domain.enumeration.Tab;
import br.com.futbid.swing.ui.listener.AuthActionListener;
import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.tab.WorkTabPanel;
import br.com.futbid.swing.ui.utils.Colors;

@Component
public class AuthenticationPainelImpl extends JPanel implements AuthenticationPainel {

    private static final long serialVersionUID = 2014030601L;

    private JTextField email;
    private JPasswordField password;
    private JTextField answer;

    @Autowired
    private AuthActionListener authActionListener;

    private WorkTabPanel workTabPanel;

    public AuthenticationPainelImpl() {
	this.email = new JTextField();
	this.password = new JPasswordField();
	this.answer = new JTextField();
    }

    @PostConstruct
    public void init() {

	setName(Tab.LOGIN.getName());

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
	fieldPanel.add(email);

	fieldPanel.add(createLable("Password: ", Colors.BACK_GROUND));
	fieldPanel.add(password);

	fieldPanel.add(createLable("Answer: ", Colors.BACK_GROUND));
	fieldPanel.add(answer);

	JButton loginButton = new JButton("Login");
	loginButton.addActionListener(authActionListener);

	JPanel controllPanel = new JPanel(new FlowLayout(2));
	controllPanel.setBackground(Colors.BACK_GROUND);
	controllPanel.add(loginButton);

	JPanel centerContainer = new JPanel(new BorderLayout());
	centerContainer.add(fieldPanel, "North");
	centerContainer.add(controllPanel, "Center");

	Font font = new Font("Arial", 1, 14);
	add(createLable("Please provide your FUT credentials: ", Colors.BACK_GROUND, Colors.HEADER_COLOR, font, null,
		null, false), "North");
	add(centerContainer, "Center");
    }

    @Override
    public void setWorkTabPanel(WorkTabPanel workTabPanel) {
	this.workTabPanel = workTabPanel;
    }

    @Override
    public void clearFields() {
	email.setText("");
	password.setText("");
	answer.setText("");
    }

    @Override
    public void showAutoBuyerPanel() {
	workTabPanel.showAutoBuyerPanel();
    }

    @Override
    public Credentials getCredentials() {
	Credentials credentials = new Credentials();
	/*
	 * credentials.setLogin(emailField.getText()); credentials.setPassword(passwordField.getText());
	 * credentials.setSecretAnswer(answerField.getText());
	 */

	return credentials;
    }

}
