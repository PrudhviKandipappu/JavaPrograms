// Main class to the CRUD program which are uses diffrent databases

import java.io.*;

class TestCRUD
{
	public static void main(String[]args) throws Exception
	{
		File fpClassName = new File("ClassName.cfg");
		BufferedReader fr = new BufferedReader(new FileReader(fpClassName));
		iCRUD objiCRUD = (iCRUD)Class.forName(fr.readLine()).newInstance();
		while (true) {
			System.out.println("............MENU............")
			System.out.println("1.AddAccount 2.ShowAccounts 3.TransferMoney 4.DeleteAccount 5.SearchAccount 6.Exit");
			System.out.print("Enter your transaction from above list: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int option = Integer.parseInt(br.readLine());
			switch (option){
				case 1: objiCRUD.addAccount();
						break;
				case 2:	objiCRUD.showAccounts();
						break;
				case 3: objiCRUD.transferMoney();
						break;
				case 4: objiCRUD.deleteAccount();
						break;
				case 5: objiCRUD.searchAccount();
						break;
				case 6: objiCRUD.exit();
						break;
				default: System.out.println("Invalid option please chech that once!");			
						 break;
			}
		}
	}
}