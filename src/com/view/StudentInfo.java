package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Student;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInfo extends JFrame {

	private JPanel contentPane;
	private String currentUser;
	private JLabel studentInfoHeader;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton goBackButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo("test");
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
	public StudentInfo(String currentUser) {
		this.currentUser = currentUser;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentInfoHeader());
		contentPane.add(getSeparator());
		contentPane.add(getScrollPane());
		contentPane.add(getGoBackButton());
		displayTable();
	}

	private JLabel getStudentInfoHeader() {
		if (studentInfoHeader == null) {
			studentInfoHeader = new JLabel("Student Info");
			studentInfoHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
			studentInfoHeader.setVerticalAlignment(SwingConstants.BOTTOM);
			studentInfoHeader.setHorizontalAlignment(SwingConstants.CENTER);
			studentInfoHeader.setBounds(10, 11, 576, 54);
		}
		return studentInfoHeader;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 63, 576, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 76, 553, 241);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "First Name", "Last Name", "Username"
				}
			));
		}
		return table;
	}
	
	private void displayTable() {
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		StudentService studentService = new StudentServiceImpl();
		
		for(Student student : studentService.getAllStudent()) {
			tmodel.addRow(new Object[] {
					student.getId(),
					student.getFirstName(),
					student.getLastName(),
					student.getUserName()
			});
		}
	}
	private JButton getGoBackButton() {
		if (goBackButton == null) {
			goBackButton = new JButton("go back");
			goBackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new StudentHome(currentUser).setVisible(true);
					dispose();
				}
			});
			goBackButton.setBounds(484, 11, 89, 23);
		}
		return goBackButton;
	}
}
