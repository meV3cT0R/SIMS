package com.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Student;
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

public class StudentRegister extends JFrame {

	private JPanel contentPane;
	private JLabel studentRegisterHeader;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegister frame = new StudentRegister();
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
	public StudentRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentRegisterHeader());
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
	}
	private JLabel getStudentRegisterHeader() {
		if (studentRegisterHeader == null) {
			studentRegisterHeader = new JLabel("Student Register");
			studentRegisterHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
			studentRegisterHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			studentRegisterHeader.setHorizontalAlignment(SwingConstants.CENTER);
			studentRegisterHeader.setBounds(0, 0, 334, 51);
		}
		return studentRegisterHeader;
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
					if(passwordField.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordField,"password cannot be empty");
						return;
					}
					StudentService studentService = new StudentServiceImpl();
					Student student = new Student();
					student.setFirstName(firstNameField.getText());
					student.setLastName(lastNameField.getText());
					student.setUserName(userNameField.getText());
					student.setPassword(passwordField.getText());
					
					if(studentService.register(student)) {
						JOptionPane.showMessageDialog(null, "Succesfully registerd");
						new StudentLogin().setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}
				}
			});
			registerButton.setBounds(112, 286, 89, 23);
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
			clearButton.setBounds(211, 286, 93, 23);
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
			passwordLabel.setBounds(10, 223, 91, 25);
		}
		return passwordLabel;
	}
	private JPasswordField getPasswordField_1() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(112, 225, 192, 28);
		}
		return passwordField;
	}
}
