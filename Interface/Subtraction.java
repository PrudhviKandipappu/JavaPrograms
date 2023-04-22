// Create a class Subtraction which implements Operation interface

class Subtraction implements Operation
{
	public void performOperation(int number1, int number2){
		System.out.println("Subtraction of " + number1 + "and " + number2 + "is: " + (number1 - number2));
	}
}