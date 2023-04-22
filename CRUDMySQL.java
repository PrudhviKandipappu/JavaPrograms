// Do a CRUD program with MySQL database.

import java.sql.*;
import java.io.*;


class SuperMarket
{
	Connection dbConnection;
	SuperMarket()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://138.68.140.83/dbPrudhvi", "Prudhvi", "Prudhvi@2004");
			// this.getSupplierID("Xiaomi");
			// this.ShowStock();
			this.UpdateStock();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	public void addStock(int ItemID, String Description, int UnitPrice, int StockQty, int SupplierID){
		String InsertQuery = "INSERT INTO Item(ItemID, Description, StockQty, UnitPrice, SupplierID)" + "VALUES (?, ?, ?, ?, ?)";
		try{
			PreparedStatement stmt = this.dbConnection.prepareStatement(InsertQuery);
			stmt.setInt(1, ItemID);
			stmt.setString(2, Description);
			stmt.setInt(3, StockQty);
			stmt.setInt(4, UnitPrice);
			stmt.setInt(5, SupplierID);		
			System.out.println(stmt.execute());
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	public void ShowStock() {
		String SelectQuery = "SELECT *FROM Item";
		try{
			Statement stmt = this.dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(SelectQuery);
			while(rs.next()){
				System.out.print(rs.getInt(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getInt(3) + " ");
				System.out.print(rs.getInt(4) + " ");
				System.out.println(rs.getInt(5));
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	public void UpdateStock() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter ItemID: ");
		int ItemID = Integer.parseInt(br.readLine());
		System.out.print("How much quantity you want to add? ");
		int NewStockQty = Integer.parseInt(br.readLine());
		String UpdateQuery = "UPDATE Item SET StockQty = StockQty + " + NewStockQty + "WHERE ItemID = " + ItemID;
		Statement stmt = dbConnection.createStatement();
		stmt.executeUpdate(UpdateQuery);
	}

	private void getSupplierID(String Supplier) {
		String SelectQuery = "SELECT SupplierID FROM Supplier WHERE SupplierName = " + Supplier;
		Statement stmt = null;
		try{
			// PreparedStatement pstmt = dbConnection.prepareStatement(SelectQuery);
			// pstmt.setString(1, Supplier);
			stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(SelectQuery);
			rs.next(); 
			System.out.println(rs.getInt(1));
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}

class CRUDMySQL
{
	public static void main(String[]args) throws Exception
	{
		try{
			SuperMarket ObjSuperMarket = new SuperMarket();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}