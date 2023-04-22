// CRUD Interface

interface iCRUD
{
	public void addAccount() throws Exception;
	public void showAccounts()throws Exception;
	public void transferMoney() throws Exception;
	public void deleteAccount() throws Exception;
	public void searchAccount() throws Exception;
	public void exit() throws Exception;
}