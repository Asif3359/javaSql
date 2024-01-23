package pakage_1;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class p1_Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
			System.out.println("database connect");
			Statement stmt = con.createStatement();
			Scanner scan = new Scanner(System.in);
			String query = "";
			System.out.println("1. Add User ");
			System.out.println("2. Read User ");
			System.out.println("3. Update User ");
			System.out.print("Enter Your Choise :");
			String choise = scan.nextLine();
			
			switch(choise)
			{
			case "1":
				System.out.print("Enter Your id: ");
		        int id = scan.nextInt();
		        // Consume the newline character
		        scan.nextLine();

		        System.out.print("Enter Your Name: ");
		        String Name = scan.nextLine();

		        System.out.print("Enter Your Email: ");
		        String Email = scan.nextLine();

		        System.out.print("Enter Your Phone: ");
		        int Phone = scan.nextInt();

		        System.out.print("Enter Your cgpa: ");
		        float cgpa = scan.nextFloat();

				 query = "INSERT INTO student (id , Name , Email, Phone, cgpa) VALUES ('"+id+"','"+Name+"','"+Email+"','"+Phone+"','"+cgpa+"')";
				stmt.executeUpdate(query);
				break ;
			case "2":
				 query = "SELECT * FROM student";
				ResultSet rs = stmt.executeQuery(query);
				System.out.println("ID:\tName:\t\tEmail:\t\t\t\tPhone:\t\tCGPA:\n");
				while (rs.next()) {
				    int ID = rs.getInt("id");
				    String name = rs.getString("Name");
				    String email = rs.getString("Email");
				    int phone = rs.getInt("Phone");
				    float Cg = rs.getFloat("cgpa");

				    // Use printf for formatted output
				    System.out.printf("%d\t%-15s\t%-30s\t%d\t%-30.2f\n", ID, name, email, phone, Cg);
				}

				break ;
			case "3":
				System.out.print("Enter Your id: ");
		        int U_id = scan.nextInt();
		        // Consume the newline character
		        scan.nextLine();

		        System.out.print("Enter Your Name: ");
		        String u_Name = scan.nextLine();

		        System.out.print("Enter Your Email: ");
		        String u_Email = scan.nextLine();

		        System.out.print("Enter Your Phone: ");
		        int u_Phone = scan.nextInt();

		        System.out.print("Enter Your cgpa: ");
		        float u_cgpa = scan.nextFloat();
		        query = " UPDATE student SET id ='"+U_id+"', Name='"+u_Name+"', Email='"+u_Email+"', Phone='"+u_Phone+"', cgpa='"+u_cgpa+"' WHERE id="+U_id;
				stmt.executeUpdate(query);

				break ;
			case "0":
				System.out.println("Out Of Program");
				break ;
			}
			
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.print("Error :"+e.getMessage());
		}
		
	}

}
