import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	

	
	public Admin(String title)
	{
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 368);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4,3 , 0, 0));
		
		JButton btnRegisterA = new JButton("Register a New Student");
		btnRegisterA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				StudentReg obj=new StudentReg();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnRegisterA);
		
		JButton btnViewupdatedeleteAStudent = new JButton("View/Update/Delete a Student");
		btnViewupdatedeleteAStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateDelete ud=new UpdateDelete();
				ud.setVisible(true);
			}
		});
		contentPane.add(btnViewupdatedeleteAStudent);
		
		JButton btnUpdateANew = new JButton("Update a New Notice");
		btnUpdateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AddNotice notice = new AddNotice();
				notice.setVisible(true);
			}
		});
		contentPane.add(btnUpdateANew);
		
		JButton btnViewupdatedeleteANotice = new JButton("View/Update/Delete a Notice");
		btnViewupdatedeleteANotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateDeleteNotice udn=new UpdateDeleteNotice();
				udn.setVisible(true);
			}
		});
		contentPane.add(btnViewupdatedeleteANotice);
		
		JButton btnViewAllStudent = new JButton("View All Student");
		btnViewAllStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JFrame frm=new JFrame("View all students");
				frm.setVisible(true);
				frm.setSize(800, 400);
				frm.setLocationRelativeTo(Admin.this);
				
				GetValues.getStudents();
				
				JTable t =new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				
				
			}
		});
		contentPane.add(btnViewAllStudent);
		
		JButton btnViewAllNotices = new JButton("View All Notices");
		btnViewAllNotices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{		
				JFrame frm=new JFrame("View all notices");
				frm.setVisible(true);
				frm.setSize(800, 400);
				frm.setLocationRelativeTo(Admin.this);
				
				GetValues.getNotices();
				
				JTable t =new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				
				
				
			}
		});
		contentPane.add(btnViewAllNotices);
		
		JButton btnSearchAnyStudent = new JButton("Search Any Student");
		contentPane.add(btnSearchAnyStudent);
		
		JButton btnSearchAnyNotice = new JButton("Search any Notice");
		contentPane.add(btnSearchAnyNotice);
		
		JButton btnViewStudentFeedback = new JButton("View Student Feedback");
		btnViewStudentFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
JFrame frm=new JFrame("View All Feedbacks");
				
				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getFeedbacks();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewStudentFeedback);
		
		JButton btnChangeSelfPassword = new JButton("Change Self Password");
		btnChangeSelfPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ChangePassword cp=new ChangePassword();
				cp.setVisible(true);
			}
		});
		contentPane.add(btnChangeSelfPassword);
		
		JButton btnViewAllFaculties = new JButton("View All Faculties");
		btnViewAllFaculties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame frm=new JFrame("View All Faculties");
				
				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getFaculties();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewAllFaculties);
	}

}
