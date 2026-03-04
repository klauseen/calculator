

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		boolean statement;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first number");
		double number1 = 0;

		do {
			try {
				statement = false;
				number1 = scanner.nextDouble();
			} catch (InputMismatchException e) {
				statement = true;
				System.out.println("Please enter a number");
				scanner.next();
			}
		} while (statement);

		System.out.println("Enter the operation");
		char operation;

		do {
			operation = scanner.next().charAt(0);
			if (operation != '/' && operation != '*' && operation != '-' && operation != '+') {
				statement = true;
				System.out.println("Please enter an operation");
			} else {
				statement = false;
			}

		} while (statement);

		System.out.println("Enter the second number");
		double number2 = 0;

		do {
			try {
				statement = false;
				number2 = scanner.nextDouble();
			} catch (InputMismatchException e) {
				statement = true;
				System.out.println("Enter a number");
				scanner.next();
			}
		} while (statement);

		switch (operation) {
		case '/':
			division(number1, number2);
			return;
		case '*':
			multiplication(number1, number2);
			return;
		case '-':
			subtraction(number1, number2);
			return;
		case '+':
			addition(number1, number2);
			return;
		}
	}

	public static void addition(double number1, double number2) {
		double addition = number1 + number2;
		System.out.println(addition);
	}

	public static void division(double number1, double number2) {
		if(number2 == 0) {
			System.out.println("Can't make division to 0");
		}else {
		double division = number1 / number2;
		System.out.println(division);
		}
	}

	public static void subtraction(double number1, double number2) {
		double substraction = number1 - number2;
		System.out.println(substraction);
	}

	public static void multiplication(double number1, double number2) {
		double multiplication = number1 * number2;
		System.out.println(multiplication);
	}

}
