package pakage_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class p1_Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
		System.out.println("database connect");
		
		Statement stmt = con.createStatement();
		String query = "SELECT * FROM student";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("ID:\tName:\t\tEmail:\t\t\t\tPhone:\t\tCGPA:\n");
		while (rs.next()) {
		    int id = rs.getInt("id");
		    String name = rs.getString("Name");
		    String email = rs.getString("Email");
		    int phone = rs.getInt("Phone");
		    float cgpa = rs.getFloat("cgpa");

		    // Use printf for formatted output
		    System.out.printf("%d\t%-15s\t%-30s\t%d\t%-30.2f\n", id, name, email, phone, cgpa);
		}


	}

}
