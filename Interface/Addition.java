// Create a class called Addition which implements Operation interface

class Addition implements Operation
{
	public void performOperation(int number1, int number2){
		System.out.println("Sum of " + number1 + "and " + number2 + "is: " + (number1 + number2));
	}
}