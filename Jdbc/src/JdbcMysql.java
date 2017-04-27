import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JdbcMysql 
{
	public static void main(String[] args) throws Exception 
	{
		
	
	Class.forName("com.mysql.jdbc.Driver");	
	 String url="jdbc:mysql://localhost:3306/my1stdatabase";
	Connection connection=(Connection)DriverManager.getConnection(url,"root","root123");
	
	Statement statement=(Statement) connection.createStatement();
	
	//statement.executeUpdate("insert into employee values(1000, 'Sunil', 500000)");
	//statement.executeUpdate("insert into employee values(1001, 'Manoj', 4500000)");
//	statement.executeUpdate("insert into employee values(1002, 'Prince', 5000000)");
//	statement.executeUpdate("insert into employee values(1003, 'Gautam', 6500000)");
//	statement.executeUpdate("insert into employee values(1004, 'Mukesh', 700000)");
	//statement.executeUpdate("insert into employee values(1005, 'Mohan', 750000)");
	//statement.executeUpdate("insert into employee values(1006, 'Shrikant', 14500000)");
	//statement.executeUpdate("insert into employee values(1007, 'Miral', 8500000)");
	
	//statement.executeUpdate("delete from employee where id=1004");


	
	//statement.executeUpdate("UPDATE employee SET name='sagar' where id=1005");
	statement.executeUpdate("insert into employee values(6666, 'jaggu', 85000)");
	ResultSet resultset=(ResultSet) statement.executeQuery("select * from employee");
	while(resultset.next())
	{
		
		System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t\t"+resultset.getInt(3));
	}
	}

}
