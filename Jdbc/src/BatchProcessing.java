import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BatchProcessing 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner scanner=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");	
		 String url="jdbc:mysql://localhost:3306/my1stdatabase";
		Connection connection=(Connection)DriverManager.getConnection(url,"root","root123");
		
		Statement statement = (Statement) connection.createStatement();
		
		connection.setAutoCommit(false);
		
		String SQL = "INSERT INTO employee (id, name, salary) " +
	             "VALUES(3000,'Zia', 30000)";
		
			statement.addBatch(SQL);
			
			String SQL1 = "UPDATE employee SET name = 'Virat' " +
		             "WHERE id =1002";
			
			statement.addBatch(SQL1);
			
			
			String SQL2 = "INSERT INTO employee (id, name, salary) " +
		             "VALUES(?, ?, ?)";
			
			PreparedStatement pstatement= (PreparedStatement) connection.prepareStatement(SQL2);
			connection.setAutoCommit(false);
			
			pstatement.setInt(1, 4001);
			pstatement.setString(2, "Jack");
			pstatement.setInt(3, 45000);
			
			pstatement.addBatch();
			
			
			int[] count = statement.executeBatch();
			int [] count1=pstatement.executeBatch();
			connection.commit();
		
	}

}
