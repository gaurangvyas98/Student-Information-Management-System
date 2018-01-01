import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Student extends JFrame 
{
	
	
	private JPanel contentPane;

	public Student(String title)
	{
		super(title);
		setTitle("STUDENT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		setResizable(false);
		setBounds(100, 100, 505, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnViewSelfProfile = new JButton("View/Update Profile");
		btnViewSelfProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateDelete ud=new UpdateDelete();
				ud.setVisible(true);
				
			}
		});
		contentPane.add(btnViewSelfProfile, BorderLayout.NORTH);
		
		JButton btnViewAllNotices = new JButton("View All Notices");
		btnViewAllNotices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame frm=new JFrame("View all notices");
				frm.setVisible(true);
				frm.setSize(800, 400);
				frm.setLocationRelativeTo(Student.this);
				
				GetValues.getNotices();
				
				JTable t =new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				
			}
		});
		
		contentPane.add(btnViewAllNotices, BorderLayout.WEST);
		
		JButton btnUpdateProfile = new JButton("Change Password");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ChangePasswordStudent cps=new ChangePasswordStudent();
				cps.setVisible(true);
			}
		});
		contentPane.add(btnUpdateProfile, BorderLayout.SOUTH);
		
		JButton btnSubmitFeedback = new JButton("Submit Feedback");
		btnSubmitFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Feedback fd=new Feedback();
				fd.setVisible(true);
			}
		});
		contentPane.add(btnSubmitFeedback, BorderLayout.EAST);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("student.png"));
		
		contentPane.add(label, BorderLayout.CENTER);
	}

}
