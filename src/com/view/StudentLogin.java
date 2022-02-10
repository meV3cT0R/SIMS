package com.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.StudentService;
import com.service.StudentServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class StudentLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel studentLoginHeader;
	private JSeparator separator;
	private JTextField userNameField;
	private JButton loginButton;
	private JButton clearButton;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentLoginHeader());
		contentPane.add(getSeparator());
		contentPane.add(getUserNameField());
		contentPane.add(getLoginButton());
		contentPane.add(getClearButton());
		contentPane.add(getUserNameLabel());
		contentPane.add(getPasswordLabel());
		contentPane.add(getPasswordField());
	}

	private JLabel getStudentLoginHeader() {
		if (studentLoginHeader == null) {
			studentLoginHeader = new JLabel("Student Login");
			studentLoginHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
			studentLoginHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			studentLoginHeader.setHorizontalAlignment(SwingConstants.CENTER);
			studentLoginHeader.setBounds(10, 11, 443, 52);
		}
		return studentLoginHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 61, 443, 2);
		}
		return separator;
	}
	private JTextField getUserNameField() {
		if (userNameField == null) {
			userNameField = new JTextField();
			userNameField.setBounds(153, 93, 195, 25);
			userNameField.setColumns(10);
		}
		return userNameField;
	}
	private JButton getLoginButton() {
		if (loginButton == null) {
			loginButton = new JButton("Log In");
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(userNameField.getText().isBlank()) {
						JOptionPane.showMessageDialog(userNameField, "Username field should not be empty");
						return;
					}
					if(passwordField.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordField, "Password field should not be empty");
						return;
					}
					
					StudentService studentService = new StudentServiceImpl();
					if(studentService.login(userNameField.getText(), passwordField.getText())) {
						new StudentHome().setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Username/Password is invalid!");
						return;
					}
					
				}
			});
			loginButton.setBounds(153, 207, 82, 23);
		}
		return loginButton;
	}
	private JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton("clear");
			clearButton.setBounds(268, 207, 82, 23);
		}
		return clearButton;
	}
	private JLabel getUserNameLabel() {
		if (userNameLabel == null) {
			userNameLabel = new JLabel("Username");
			userNameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
			userNameLabel.setBounds(73, 93, 142, 25);
		}
		return userNameLabel;
	}
	private JLabel getPasswordLabel() {
		if (passwordLabel == null) {
			passwordLabel = new JLabel("password");
			passwordLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
			passwordLabel.setBounds(73, 148, 142, 25);
		}
		return passwordLabel;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(156, 148, 192, 25);
		}
		return passwordField;
	}
}
