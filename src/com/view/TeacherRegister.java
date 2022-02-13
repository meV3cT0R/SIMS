package com.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Student;
import com.model.Teacher;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

public class TeacherRegister extends JFrame {

	private JPanel contentPane;
	private JLabel TeacherRegisterHeader;
	private JSeparator separator;
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JTextField userNameField;
	private JButton registerButton;
	private JButton clearButton;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JDateChooser dateChooser;
	private JLabel emailLabel;
	private JLabel dateChooserLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherRegister frame = new TeacherRegister();
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
	public TeacherRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTeacherRegisterHeader());
		contentPane.add(getSeparator());
		contentPane.add(getFirstNameLabel());
		contentPane.add(getFirstNameField());
		contentPane.add(getLastNameLabel());
		contentPane.add(getLastNameField());
		contentPane.add(getUserNameField());
		contentPane.add(getRegisterButton());
		contentPane.add(getClearButton());
		contentPane.add(getUserNameLabel());
		contentPane.add(getPasswordLabel());
		contentPane.add(getPasswordField_1());
		contentPane.add(getEmailField());
		contentPane.add(getDateChooser());
		contentPane.add(getEmailLabel());
		contentPane.add(getDateChooserLabel());
	}
	private JLabel getTeacherRegisterHeader() {
		if (TeacherRegisterHeader == null) {
			TeacherRegisterHeader = new JLabel("Student Register");
			TeacherRegisterHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
			TeacherRegisterHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			TeacherRegisterHeader.setHorizontalAlignment(SwingConstants.CENTER);
			TeacherRegisterHeader.setBounds(0, 0, 334, 51);
		}
		return TeacherRegisterHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 49, 324, 2);
		}
		return separator;
	}
	private JLabel getFirstNameLabel() {
		if (firstNameLabel == null) {
			firstNameLabel = new JLabel("First Name");
			firstNameLabel.setBounds(10, 62, 91, 25);
		}
		return firstNameLabel;
	}
	private JTextField getFirstNameField() {
		if (firstNameField == null) {
			firstNameField = new JTextField();
			firstNameField.setBounds(112, 59, 192, 28);
			firstNameField.setColumns(10);
		}
		return firstNameField;
	}
	private JLabel getLastNameLabel() {
		if (lastNameLabel == null) {
			lastNameLabel = new JLabel("Last Name");
			lastNameLabel.setBounds(10, 107, 91, 25);
		}
		return lastNameLabel;
	}
	private JTextField getLastNameField() {
		if (lastNameField == null) {
			lastNameField = new JTextField();
			lastNameField.setColumns(10);
			lastNameField.setBounds(112, 109, 192, 28);
		}
		return lastNameField;
	}
	private JTextField getUserNameField() {
		if (userNameField == null) {
			userNameField = new JTextField();
			userNameField.setColumns(10);
			userNameField.setBounds(112, 167, 192, 28);
		}
		return userNameField;
	}
	private JButton getRegisterButton() {
		if (registerButton == null) {
			registerButton = new JButton("Register");
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(firstNameField.getText().isBlank()) {
						JOptionPane.showMessageDialog(firstNameField,"First Name cannot be empty");
						return;
					}
					if(lastNameField.getText().isBlank()) {
						JOptionPane.showMessageDialog(lastNameField,"Last Name cannot be empty");
						return;
					}
					if(userNameField.getText().isBlank()) {
						JOptionPane.showMessageDialog(userNameField,"User name cannot be empty");
						return;
					}
					if(emailField.getText().isBlank()) {
						JOptionPane.showMessageDialog(emailField,"Email Field cannot be empty");
						return;
					}
					if(dateChooser.getDate().after(new Date())) {
						JOptionPane.showMessageDialog(dateChooser,"you can't be older than today");
						return;
					}
					if(passwordField.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordField,"password cannot be empty");
						return;
					}
				
					TeacherService ts = new TeacherServiceImpl();
					Teacher teacher = new Teacher();
					teacher.setFirstName(firstNameField.getText());
					teacher.setLastName(lastNameField.getText());
					teacher.setUserName(userNameField.getText());
					teacher.setEmail(emailField.getText());
					teacher.setPassword(passwordField.getText());
					teacher.setDob(dateChooser.getDate());
					
					if(ts.register(teacher)) {
						JOptionPane.showMessageDialog(null,"Successfully Register");
						new TeacherLogin().setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Sorry ! something went wrong");
					}
				}
			});
			registerButton.setBounds(112, 382, 89, 23);
		}
		return registerButton;
	}
	private JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton("clear");
			clearButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			clearButton.setBounds(211, 382, 93, 23);
		}
		return clearButton;
	}
	private JLabel getUserNameLabel() {
		if (userNameLabel == null) {
			userNameLabel = new JLabel("Username");
			userNameLabel.setBounds(10, 169, 91, 25);
		}
		return userNameLabel;
	}
	private JLabel getPasswordLabel() {
		if (passwordLabel == null) {
			passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(10, 329, 91, 25);
		}
		return passwordLabel;
	}
	private JPasswordField getPasswordField_1() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(112, 327, 192, 28);
		}
		return passwordField;
	}
	private JTextField getEmailField() {
		if (emailField == null) {
			emailField = new JTextField();
			emailField.setColumns(10);
			emailField.setBounds(112, 217, 192, 28);
		}
		return emailField;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(111, 271, 193, 28);
		}
		return dateChooser;
	}
	private JLabel getEmailLabel() {
		if (emailLabel == null) {
			emailLabel = new JLabel("Username");
			emailLabel.setBounds(10, 224, 91, 25);
		}
		return emailLabel;
	}
	private JLabel getDateChooserLabel() {
		if (dateChooserLabel == null) {
			dateChooserLabel = new JLabel("Username");
			dateChooserLabel.setBounds(10, 274, 91, 25);
		}
		return dateChooserLabel;
	}
}
