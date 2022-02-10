package com.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





public class StudentHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel studentHomeHeader;
	private JSeparator separator;
	private JLabel welcomeLabel;
	private JButton logoutButton;
	private JLabel userNameLabel;
	private JLabel settingLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome();
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
	public StudentHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentHomeHeader());
		contentPane.add(getSeparator());
		contentPane.add(getWelcomeLabel());
		contentPane.add(getLogoutButton());
		contentPane.add(getUserNameLabel());
		contentPane.add(getSettingLabel());
	}
	private JLabel getStudentHomeHeader() {
		if (studentHomeHeader == null) {
			studentHomeHeader = new JLabel("Student Home");
			studentHomeHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			studentHomeHeader.setHorizontalAlignment(SwingConstants.CENTER);
			studentHomeHeader.setBounds(23, 11, 446, 48);
		}
		return studentHomeHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 62, 539, 2);
		}
		return separator;
	}
	private JLabel getWelcomeLabel() {
		if (welcomeLabel == null) {
			welcomeLabel = new JLabel("Welcome");
			welcomeLabel.setBounds(10, 74, 71, 18);
		}
		return welcomeLabel;
	}
	private JButton getLogoutButton() {
		if (logoutButton == null) {
			logoutButton = new JButton("Log out");
			logoutButton.setBounds(460, 21, 89, 23);
		}
		return logoutButton;
	}
	private JLabel getUserNameLabel() {
		if (userNameLabel == null) {
			userNameLabel = new JLabel("");
			userNameLabel.setBounds(67, 74, 71, 18);
		}
		return userNameLabel;
	}
	private JLabel getSettingLabel() {
		if (settingLabel == null) {
			settingLabel = new JLabel("setting");
			settingLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new StudentSetting().setVisible(true);
					
				}
			});
			settingLabel.setBounds(486, 76, 46, 14);
		}
		return settingLabel;
	}
}
