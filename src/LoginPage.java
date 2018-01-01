import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 130, 505, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		//setResizable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("login1.png"));
		
		JLabel lblUserenrollmentempid = new JLabel("Username(Enrollment/Empid)");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		JLabel lblUsertype = new JLabel("Usertype");
		
		passwordField = new JPasswordField();
		
		String type[]={"Select","Admin","Student"};
		JComboBox comboBox = new JComboBox(type);
		
		JButton btnLoginNow = new JButton("LOGIN NOW");
		btnLoginNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String userid=textField.getText();
				char ch[]=passwordField.getPassword();
			    String password =String.copyValueOf(ch);
				String type = (String) comboBox.getSelectedItem();
				//System.out.println(userid+"::"+password+"::"+type);
				Connection con=DBInfo.getConn();
				int flag=0;
				
				if(type.equalsIgnoreCase("admin"))
				{
					String query="select * from faculty_registration where empid=? and password=? ";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, userid);
						ps.setString(2, password);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							break;
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(flag==1)
					{
						Admin a=new Admin("Admin Page");
						a.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(LoginPage.this,"wrong username or password", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
				}
				if(type.equalsIgnoreCase("student"))
				{
					String query="select * from student_registration where enrollment=? and password=? ";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, userid);
						ps.setString(2, password);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							break;
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(flag==1)
					{
						Student s=new Student("Student Page");
						s.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(LoginPage.this,"wrong username or password", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		});
		
		JButton btnReset = new JButton("RESET");
		
		JButton btnNewuserSignup = new JButton("NEW USER SIGNUP");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLoginNow, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsertype, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserenrollmentempid, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewuserSignup, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addGap(225))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserenrollmentempid, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsertype, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoginNow, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewuserSignup, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
