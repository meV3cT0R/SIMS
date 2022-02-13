package com.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.service.TeacherService;
import com.service.TeacherServiceImpl;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel TeacherLoginHeader;
	private JSeparator separator;
	private JTextField userNameField;
	private JButton loginButton;
	private JButton clearButton;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel registerLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin frame = new TeacherLogin();
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
	public TeacherLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTeacherLoginHeader());
		contentPane.add(getSeparator());
		contentPane.add(getUserNameField());
		contentPane.add(getLoginButton());
		contentPane.add(getClearButton());
		contentPane.add(getUserNameLabel());
		contentPane.add(getPasswordLabel());
		contentPane.add(getPasswordField());
		contentPane.add(getRegisterLink());
	}

	private JLabel getTeacherLoginHeader() {
		if (TeacherLoginHeader == null) {
			TeacherLoginHeader = new JLabel("Teacher Login");
			TeacherLoginHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
			TeacherLoginHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			TeacherLoginHeader.setHorizontalAlignment(SwingConstants.CENTER);
			TeacherLoginHeader.setBounds(10, 11, 443, 52);
		}
		return TeacherLoginHeader;
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
					
					TeacherService ts= new TeacherServiceImpl();
					if(ts.login(userNameField.getText(), passwordField.getText())) {
						JOptionPane.showMessageDialog(null, "Successfully Logged In");
						new TeacherHome(userNameField.getText()).setVisible(true);
						dispose();
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
	private JLabel getRegisterLink() {
		if (registerLink == null) {
			registerLink = new JLabel("click here if you are new");
			registerLink.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new TeacherRegister().setVisible(true);
					dispose();
				}
			});
			registerLink.setHorizontalAlignment(SwingConstants.CENTER);
			registerLink.setBounds(83, 243, 341, 14);
		}
		return registerLink;
	}
}
