// Class to define Bank CRUD operations

import java.sql.*;
import java.io.*;

class cCRUD
{
	public Connection dbConnection = null;
	public void addAccount() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter AccountNumber: ");
		String accountNumber = br.readLine();
		System.out.print("Enter AccountHolder Name: ");
		String accountHolder = br.readLine();
		System.out.print("Enter Balance: ");
		int balance = Integer.parseInt(br.readLine());
		Statement stmt = dbConnection.createStatement();
		String insertQuery = "INSERT INTO BankAccounts(AccountNumber, AccountHolder, Balance) VALUES ('" +accountNumber+ "','" +accountHolder+ "','" +balance+"')";
		System.out.println(stmt.executeUpdate(insertQuery));
		stmt.close();
	}

	public void showAccounts() throws Exception
	{
		String selectQuery = "SELECT *FROM BankAccounts";
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		System.out.println("------------------------------------------------------");
		System.out.format("%-15s%-20s%-10s\n", "AccountNumber", "AccountHolder", "Balance");
		System.out.println("------------------------------------------------------");
		while (rs.next()){
			System.out.format("%-15s", rs.getString(1));
			System.out.format("%-20s", rs.getString(2));
			System.out.format("%-10s\n", rs.getInt(3));
		}
		System.out.println("------------------------------------------------------");
		stmt.close();
	}

	public void transferMoney() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Your Account Number: ");
		String senderAccountNumber = br.readLine();
		System.out.print("Enter reciever's Account Number: ");
		String recieverAccountNumber = br.readLine();
		System.out.print("How much you want to transfer? ");
		int amount = Integer.parseInt(br.readLine());
		String selectQuery = "SELECT COUNT(*) FROM BankAccounts WHERE AccountNumber = ? OR AccountNumber = ?";
		PreparedStatement pstmt = dbConnection.prepareStatement(selectQuery);
		pstmt.setString(1, senderAccountNumber);
		pstmt.setString(2, recieverAccountNumber);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		if (count == 2){
			String senderUpdateQuery = "UPDATE BankAccounts SET Balance = Balance - ? WHERE AccountNumber = ?";
			String recieverUpdateQuery = "UPDATE BankAccounts SET Balance = Balance + ? WHERE AccountNumber = ?";
			pstmt = dbConnection.prepareStatement(senderUpdateQuery);
			pstmt.setInt(1, amount);
			pstmt.setString(2, senderAccountNumber);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = dbConnection.prepareStatement(recieverUpdateQuery);
			pstmt.setInt(1, amount);
			pstmt.setString(2, recieverAccountNumber);
			pstmt.executeUpdate();
			pstmt.close();
		}
	}

	public void deleteAccount() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Account Number: ");
		String accountNumber = br.readLine();
		String deleteQuery = "DELETE FROM BankAccounts WHERE AccountNumber = ?";
		PreparedStatement pstmt = dbConnection.prepareStatement(deleteQuery);
		pstmt.setString(1, accountNumber);
		pstmt.executeUpdate();
		pstmt.close();
	}

	public void searchAccount() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Account Number: ");
		String accountNumber = br.readLine();
		String searchQuery = "SELECT *FROM BankAccounts WHERE AccountNumber = ?";
		PreparedStatement pstmt = dbConnection.prepareStatement(searchQuery);
		pstmt.setString(1, accountNumber);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println("Account Number: " + rs.getString(1));
			System.out.println("Account Holder: " + rs.getString(2));
			System.out.println("Balance: " + rs.getInt(3));
		}
		pstmt.close();
	}

	public void exit() throws Exception
	{
		dbConnection.close();
		System.out.println("Thank You!");
		System.exit(0);
	}
}