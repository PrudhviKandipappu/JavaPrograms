// Create a CRUDSQLite class which extends CRUDOperations and implements CRUDBank interface

import java.sql.*;

class cCRUDSQLite extends cCRUD implements iCRUD
{
	cCRUDSQLite()
	{
		try{
			dbConnection = DriverManager.getConnection("jdbc:sqlite:Trainig.db");
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}