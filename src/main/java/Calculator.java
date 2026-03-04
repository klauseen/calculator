package main.java;





import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {


	public static double addition(double number1, double number2) {
		return number1 + number2;
	}

	public static double division(double number1, double number2) {
		if(number2 == 0) {
			return 0;
		}else {
		return number1 / number2;
		}
	}

	public static double subtraction(double number1, double number2) {
		return number1 - number2;

	}

	public static double multiplication(double number1, double number2) {
		return number1 * number2;
	}

	public static double toPercentage(double number) {
		return number / 100;
	}

}
