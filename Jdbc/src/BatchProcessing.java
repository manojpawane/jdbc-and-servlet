import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BatchProcessing {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/my1stdatabase";
		Connection connection = (Connection) DriverManager.getConnection(url, "root", "root123");

		Statement statement = (Statement) connection.createStatement();

		connection.setAutoCommit(false); // what is the 

		String SQL = "INSERT INTO employee (id, name, salary) " + "VALUES(66,'nena', 50000)";
		

		statement.addBatch(SQL);

	/*	String SQL1 = "UPDATE employee SET name = 'Virat' " + "WHERE id =1002";

		statement.addBatch(SQL1);*/

		String SQL2 = "INSERT INTO employee (id, name, salary) " + "VALUES(?, ?, ?)";

		PreparedStatement pstatement = (PreparedStatement) connection.prepareStatement(SQL2);
//		connection.setAutoCommit(false);

		pstatement.setInt(1, 04);
		pstatement.setString(2,"kack");
		pstatement.setInt(3, 6000);

		pstatement.addBatch();
		
		
		pstatement.setInt(1, 50);
		pstatement.setString(2,"dack");
		pstatement.setInt(3, 7000);
		pstatement.executeUpdate();
		//pstatement.addBatch();
		
		pstatement.setInt(1, 60);
		pstatement.setString(2,"kack");
		pstatement.setInt(3, 6000);
		pstatement.addBatch();
	
		
		int[] count = statement.executeBatch();
		int[] count1 = pstatement.executeBatch();
		
		for(int i=0;i<count.length;i++)
		{
		System.out.println("count statement"+count[i]);
		}
		for(int j=0;j<count1.length;j++)
		{
		System.out.println("prepared statement"+count1[j]);
		}
		connection.commit();

	}

}
