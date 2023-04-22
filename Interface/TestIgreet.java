// Test main class for inteface

class TestIgreet
{
	public static void main(String[]args) throws Exception
	{
		Igreet ogreet = (Igreet)Class.forName(args[0]).newInstance();
		ogreet.greet();
	}
}