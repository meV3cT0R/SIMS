package com.view;


import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel homeHeader;
	private JSeparator separator;
	private JButton studentLoginButton;
	private JButton teacherLoginButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getHomeHeader());
		contentPane.add(getSeparator());
		contentPane.add(getStudentLoginButton());
		contentPane.add(getTeacherLoginButton());
	}
	private JLabel getHomeHeader() {
		if (homeHeader == null) {
			homeHeader = new JLabel("Student Information Management System");
			homeHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
			homeHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			homeHeader.setHorizontalAlignment(SwingConstants.CENTER);
			homeHeader.setBounds(22, 11, 461, 53);
		}
		return homeHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 67, 486, 2);
		}
		return separator;
	}
	private JButton getStudentLoginButton() {
		if (studentLoginButton == null) {
			studentLoginButton = new JButton("Student");
			studentLoginButton.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("deprecation")
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
				}
				@SuppressWarnings("deprecation")
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
				}
			});
			studentLoginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new StudentLogin().setVisible(true);
					dispose();
				}
			});
			studentLoginButton.setBounds(205, 135, 89, 23);
		}
		return studentLoginButton;
	}
	private JButton getTeacherLoginButton() {
		if (teacherLoginButton == null) {
			teacherLoginButton = new JButton("Teacher");
			teacherLoginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TeacherLogin().setVisible(true);
					dispose();
				}
			});
			teacherLoginButton.setBounds(205, 179, 89, 23);
		}
		return teacherLoginButton;
	}
}
