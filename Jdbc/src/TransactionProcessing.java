import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class TransactionProcessing 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner scanner=new Scanner(System.in);
		
		Class.forName("com.mysql.jdbc.Driver");	
		 String url="jdbc:mysql://localhost:3306/my1stdatabase";
		 Connection connection=(Connection)DriverManager.getConnection(url,"root","root123"); 
		 Savepoint savepoint1 = null;
		 try
		 {
		
		
		Statement statement = (Statement) connection.createStatement();

   connection.setAutoCommit(false);
   
   String SQL = "INSERT INTO employee  " +
                "VALUES (4221,'abjackson', 22000)";
   statement.executeUpdate(SQL);  
   
   String SQL2 = "INSERT INTO employee  " +
                "VALUES (1557,'abnita',55000)";
   statement.executeUpdate(SQL2);
   
  
}catch(SQLException se)
{
 
   connection.rollback();
}
	
		 
		 
		 try{
			   
			   connection.setAutoCommit(false);
			   Statement statement = (Statement) connection.createStatement();
			   
			savepoint1= connection.setSavepoint("Savepoint1");
			  
			   String SQL = "INSERT INTO employee " +
			                "VALUES (1060, 'jaljala', 17000)";
			   statement.executeUpdate(SQL);  
			   //Submit a malformed SQL statement that breaks
			   String SQL1 = "INSERT INTO employee " +
			                "VALUES (1070, 'kanamati', 15000)";
			   statement.executeUpdate(SQL1);
			   // If there is no error, commit the changes.
			   connection.commit();

			}catch(SQLException se){
			   // If there is any error.
			   connection.rollback(savepoint1);
			}
		
	}

		
		
}


