package cg;
import java.sql.*;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args)  {
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pass="hr";
			Connection con=DriverManager.getConnection(url,user,pass);
			System.out.println("Connected");
			con.setAutoCommit(false);
			Scanner sc=new Scanner(System.in);
			System.out.println("enter acc id");
			int id=sc.nextInt();
			System.out.println("enter mobile no");
			long mb=sc.nextLong();
			System.out.println("enter acc holder name");
			String ah=sc.next();
			System.out.println("enter ini bala");
			double bal=sc.nextDouble();
			//dynamic query
			String sqlQuery="insert into account values(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sqlQuery);
			st.setInt(1,id);
			st.setLong(2, mb);
			st.setString(3,ah);
			st.setDouble(4, bal);
			int insertedRec=st.executeUpdate();
			System.out.println("inserted records="+insertedRec);
			con.commit();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage()+""+e.getErrorCode()+""+e.getSQLState());
					
			e.printStackTrace();
		}
	}
}
			
			
		
		
	


