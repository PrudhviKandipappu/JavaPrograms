// Main class to test operation interface

class TestOperation
{
	public static void main(String[]args) throws Exception
	{
		Operation objOperation = (Operation)Class.forName(args[0]).newInstance();
		objOperation.performOperation(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
	}
}