// Create a class which implements CRUD interface and extends CRUDOperations class

import java.sql.*;

class cCRUDMySQL extends cCRUD implements iCRUD
{
	cCRUDMySQL()
	{
		try{
			dbConnection = DriverManager.getConnection("jdbc:mysql://138.68.140.83/dbPrudhvi", "Prudhvi", "Prudhvi@2004");
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}