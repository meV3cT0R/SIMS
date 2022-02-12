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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentSetting extends JFrame {

	private JPanel contentPane;
	private JLabel studentSettingHeader;
	private JSeparator separator;
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton updateButton;
	private String currentUser;
	private JButton goBackButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSetting frame = new StudentSetting("test");
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
	public StudentSetting(String currentUser) {
		this.currentUser = currentUser;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentSettingHeader());
		contentPane.add(getSeparator());
		contentPane.add(getFirstNameLabel());
		contentPane.add(getFirstNameField());
		contentPane.add(getLastNameLabel());
		contentPane.add(getLastNameField());
		contentPane.add(getPasswordLabel());
		contentPane.add(getPasswordField());
		contentPane.add(getUpdateButton());
		contentPane.add(getGoBackButton());
	}

	private JLabel getStudentSettingHeader() {
		if (studentSettingHeader == null) {
			studentSettingHeader = new JLabel("Student Setting");
			studentSettingHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
			studentSettingHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			studentSettingHeader.setHorizontalAlignment(SwingConstants.CENTER);
			studentSettingHeader.setBounds(10, 11, 559, 51);
		}
		return studentSettingHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 60, 577, 2);
		}
		return separator;
	}
	private JLabel getFirstNameLabel() {
		if (firstNameLabel == null) {
			firstNameLabel = new JLabel("First Name");
			firstNameLabel.setBounds(10, 73, 72, 23);
		}
		return firstNameLabel;
	}
	private JTextField getFirstNameField() {
		if (firstNameField == null) {
			firstNameField = new JTextField();
			firstNameField.setBounds(78, 74, 78, 20);
			firstNameField.setColumns(10);
		}
		return firstNameField;
	}
	private JLabel getLastNameLabel() {
		if (lastNameLabel == null) {
			lastNameLabel = new JLabel("Last Name");
			lastNameLabel.setBounds(194, 73, 72, 23);
		}
		return lastNameLabel;
	}
	private JTextField getLastNameField() {
		if (lastNameField == null) {
			lastNameField = new JTextField();
			lastNameField.setColumns(10);
			lastNameField.setBounds(269, 74, 78, 20);
		}
		return lastNameField;
	}
	private JLabel getPasswordLabel() {
		if (passwordLabel == null) {
			passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(399, 73, 72, 23);
		}
		return passwordLabel;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(476, 73, 78, 20);
		}
		return passwordField;
	}
	private JButton getUpdateButton() {
		if (updateButton == null) {
			updateButton = new JButton("update");
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentService studentService = new StudentServiceImpl();
					Student student = new Student();
					student.setFirstName(firstNameField.getText().isBlank() ? null : firstNameField.getText());
					student.setLastName(lastNameField.getText().isBlank() ? null : lastNameField.getText());
					student.setUserName(currentUser);
					student.setPassword(!passwordField.getText().isBlank() ? passwordField.getText() : null);
					
					if(studentService.update(student)) {
						JOptionPane.showMessageDialog(null, "Successfully updated");
						
					}else {
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}
				}
			});
			updateButton.setBounds(476, 117, 89, 23);
		}
		return updateButton;
	}
	private JButton getGoBackButton() {
		if (goBackButton == null) {
			goBackButton = new JButton("go Back");
			goBackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new StudentHome(currentUser).setVisible(true);
					dispose();
				}
			});
			goBackButton.setBounds(480, 11, 89, 23);
		}
		return goBackButton;
	}
}
