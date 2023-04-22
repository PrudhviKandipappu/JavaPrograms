// Test a created jar file

class TestJar
{
	public static void main(String[] args)
	{
		cMath objMath = new cMath();
		cMessage objMessage = new cMessage();
		System.out.println(objMath.add(1345, 965));
		System.out.println(objMath.subtract(1567, 1400));
		System.out.println(objMath.mul(10, 5));
		System.out.println(objMath.div(150, 5));
		objMessage.greet();
		objMessage.wish();
		// System.out.println(cString.subString("welcome", 3, 4));
	}
}