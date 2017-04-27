import java.sql.*;

import java.util.*;
public class PreparedStatement1
{
	public static void main(String[] args) throws Exception 
	{
		Scanner scanner=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");	
		 String url="jdbc:mysql://localhost:3306/my1stdatabase";
		Connection connection=(Connection)DriverManager.getConnection(url,"root","root123");
		String query="insert into employee values(?,?,?)";
		PreparedStatement pstatement= (PreparedStatement) connection.prepareStatement(query);
		
		//Inserting values
		/*
		pstatement.setInt(1, 2000);
		pstatement.setString(2, "Bill");
		pstatement.setInt(3,23000);
		pstatement.executeUpdate();*/
		
/*		System.out.println("Enter the number of employees you need to insert");
		int number=scanner.nextInt();
		
		for(int i=0;i<number;i++)
		{
			System.out.println("Enter the id for employee");
			pstatement.setInt(1, scanner.nextInt());
			
			
			System.out.println("Enter the name of employee");
			pstatement.setString(2, scanner.next());
			
			
			System.out.println("Enter the salary of employee");
			pstatement.setInt(3, scanner.nextInt());
			pstatement.executeUpdate();
		}*/
		
		
		System.out.println("Enter Name:");
		String name=scanner.next();
		
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
	    String sql = "UPDATE employee set name=? WHERE id=?";
	      pstatement = connection.prepareStatement(sql);
		 
	      pstatement.setInt(2, id);
	      pstatement.setString(1, name);
	     pstatement.executeUpdate(); 
	
		
		
	/*	System.out.println("Enter the id you need to delete");
	int id=scanner.nextInt();
		String sql1="delete from employee where id =? ";
		
		pstatement=connection.prepareStatement(sql1);
		pstatement.setInt(1, id);
		pstatement.executeUpdate();
		
		
		if(pstatement!=null)
			pstatement.close();*/
		
		
		
		ResultSet resultset=(ResultSet) pstatement.executeQuery("select * from employee");
		while(resultset.next())
		{
			
			System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t\t"+resultset.getInt(3));
		}
	}

}
