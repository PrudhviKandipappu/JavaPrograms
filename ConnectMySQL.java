// Connect MySQL remote server.

import java.sql.*;

class MySQLCon{
	public static void main(String[]args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConnection = DriverManager.getConnection(
				"jdbc:mysql://138.68.140.83/dbPrudhvi", "Prudhvi", "Prudhvi@2004");
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *FROM Item");
			while (rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
			// System.out.println(rs.next());
			}
			}catch (Exception e){
				System.out.println(e);
			}
		}
	}