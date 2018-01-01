import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

public class GetValues
{
	public static Vector<Vector<String>> records;
	public static  Vector<String> header;

	public static Vector<String> getCourse()
	{
		Vector<String> v=new Vector<>();
		try
		{
			java.sql.PreparedStatement ps=DBInfo.getConn().prepareStatement("Select * from course order by name");
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				String course=res.getString(2);
				v.add(course);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.print(v);
		return v;
	}
	
	public static Vector<String> getBranch()
	{
		Vector<String> v=new Vector<>();
		try
		{
			java.sql.PreparedStatement ps=DBInfo.getConn().prepareStatement("Select * from branch order by name");
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				String branch=res.getString(2);
				v.add(branch);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.print(v);
		return v;
	}
	
	public static void getStudents()

	{
		header=new Vector<>();
		records =new Vector<>();
		String query="Select * from student_registration";
		Connection con=DBInfo.getConn();
		try
		{
			java.sql.PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			 
			ResultSetMetaData rsmd=res.getMetaData(); //metadata and records
			int colcount=rsmd.getColumnCount();
			
			for(int i=1;i<=colcount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			//only records
			while(res.next())
			{
				Vector<String> v=new Vector<>(); //Inner Vector
				for(int i=1;i<=colcount;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void getNotices()
	{
		header=new Vector<>();
		records =new Vector<>();
		String query="Select * from notice";
		Connection con=DBInfo.getConn();
		try
		{
			java.sql.PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			 
			ResultSetMetaData rsmd=res.getMetaData(); //metadata and records
			int colcount=rsmd.getColumnCount();
			
			for(int i=1;i<=colcount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			//only records
			while(res.next())
			{
				Vector<String> v=new Vector<>(); //Inner Vector
				for(int i=1;i<=colcount;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	public static void getSingleStudent()
	{
		header=new Vector<>();
		records =new Vector<>();
		String query="Select * from student_registration where enrollment=?";
		Connection con=DBInfo.getConn();
		try
		{
			java.sql.PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			 
			ResultSetMetaData rsmd=res.getMetaData(); //metadata and records
			int colcount=rsmd.getColumnCount();
			
			for(int i=1;i<=colcount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			//only records
			while(res.next())
			{
				Vector<String> v=new Vector<>(); //Inner Vector
				for(int i=1;i<=colcount;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void getFeedbacks()
	{
		records=new Vector<>();
		header=new Vector<>();
		String query="select * from feedback";
		Connection con=DBInfo.getConn();
		try
		{
			java.sql.PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			while(res.next())
			{
				Vector<String> v=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public static void getFaculties()
	{
		records=new Vector<>();
		header=new Vector<>();
		String query="select * from faculty_registration";
		Connection con=DBInfo.getConn();
		try
		{
			java.sql.PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount-1;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			while(res.next())
			{
				Vector<String> v=new Vector<>();
				for(int i=1;i<=colcount-1;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	}


	



