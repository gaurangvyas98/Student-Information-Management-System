import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo 
{
	static 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getConn()
	{
		Connection con=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","rat");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}