// Make a jar file

class cMath
{
	double pi;
	cMath() {
		pi = 3.14;
	}
	public static int mul(int number1, int number2) {
		return (number1 * number2);
	}

	public static int add(int number1, int number2) {
		return (number1 + number2);
	}

	public static int subtract(int number1, int number2) {
		return (number1 - number2);
	}

	public static int div(int number1, int number2) {
		return (number1 / number2);
	}
}

class cMessage
{
	public static void greet() {
		System.out.println("Hi Friends!!!");
	}

	public static void wish() {
		System.out.println("Happy Birthday!!!");
	}

	public static void command() {
		System.out.println("Do it first..");
	}
}

class cString
{
	public static String subString(String text, int position, int countOfCharacter) {
		String subString = "";
		for (int counter = position; counter <= (position + countOfCharacter); counter++) {
			subString += text.charAt(counter);
		}
		return subString;
	}
}