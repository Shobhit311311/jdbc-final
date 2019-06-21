package cg;
import java.sql.*;
import java.util.Scanner;

public class Demo6 {

	public static void main(String[] args) throws SQLException  {
		Connection con=null;
		
		PreparedStatement deleteSt=null;
		
		try
		{
			//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());//java 8 automatically loads driver
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pass="hr";
			 con=DriverManager.getConnection(url,user,pass);
			System.out.println("Connected");
			con.setAutoCommit(false);
			Scanner sc=new Scanner(System.in);
			System.out.println("enter account to delete");
			int id=sc.nextInt();
			deleteSt=con.prepareStatement("delete from account where aid=?");
			deleteSt.setInt(1,id);
			int deleteRec=deleteSt.executeUpdate();
			System.out.println("deleted records");
	
			
								 con.commit();
								 con.close();
		}					 
		
			
		
		catch(SQLException e)
		{
			con.rollback();
			System.out.println(e.getMessage()+""+e.getErrorCode()+""+e.getSQLState());
					
			e.printStackTrace();
		}
		finally
		{
			System.out.println("close connection");
			if(con!=null)
				con.close();
			
		}
	}
}
			
			
		
		
	


