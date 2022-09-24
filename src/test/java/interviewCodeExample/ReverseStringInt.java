package interviewCodeExample;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.engine.discovery.predicates.IsPotentialTestContainer;

import io.cucumber.java.bs.I.Is;

public class ReverseStringInt {

	public static void main(String[] args) {

//		reverseString_1("I got a job with 100K");
//		reverseString_2("I got a job with 100K");
//		reverseString_3("I got a job with 100K");
//		reverseInteger(498);
//		FizzBuzz(200);

//		FibonaciiSequence(10);
//		checkPrimeNumber(17);
		int[] numbers = { 2, 23, 18, 47, 1, 42, 23, 21, 27, 73, 49, 81, 22, 31, 54 };

//		sortArrayByBubbleSort(numbers);
		sortArrayBySelectionSort(numbers);

	}

	public static void sortArrayBySelectionSort(int[] ary) {

		for (int i = 0; i < ary.length - 1; i++) {
			int index = i;
			int min = ary[i];
			for (int j = i; j < ary.length - 1; j++) {
				if (ary[j] < min) {
					min = ary[j];
					index = j;
				}
			}
			if(i !=index) {
				int temp = ary[i];
				ary[i] = min;
				ary[index] = temp;
			}
			System.out.println("Loop time is: " + i + "  " + Arrays.toString(ary));
		}

	}

	public static void sortArrayByBubbleSort(int[] ary) {

		for (int i = 0; i < ary.length - 1; i++) {

			for (int j = 0; j < (ary.length - i - 1); j++) {
				if (ary[j] > ary[j + 1]) {
					int temp = ary[j + 1];
					ary[j + 1] = ary[j];
					ary[j] = temp;
				}
			}
			System.out.println("Loop time is: " + i + "  " + Arrays.toString(ary));
		}
	}

	public static boolean checkPrimeNumberWithReturn(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				System.out.println("This is not prime number, it can devidi by " + i);
				return false;
			}
		}
		System.out.println("This is prime number " + number);
		return true;
	}

	public static void checkPrimeNumber(int number) {
		boolean isPrime = true;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				isPrime = false;
				System.out.println("This is not prime number, it can devidi by " + i);
				break;
			}
		}

		if (isPrime)
			System.out.println("This is prime number " + number);

	}

	public static void FibonaciiSequence(int number) {

		if (number == 0) {
			System.out.println("Not valid number");
		} else if (number == 1) {
			System.out.println("0");
		} else {

			int[] fib = new int[number];
			fib[0] = 0;
			fib[1] = 1;

			for (int i = 0; i < number - 2; i++) {
//				fib[i] = fib[i - 1] + fib[i - 2];
				fib[i + 2] = fib[i] + fib[i + 1];
				System.out.println("Loop time: " + i + "  value of array index is: " + fib[i]);
				System.out.println("value of array index+1 is: " + fib[i + 1]);
				System.out.println("value of array index+2 is: " + fib[i + 2] + "\n");

			}

			System.out.println(Arrays.toString(fib));
		}

	}

	public static void FizzBuzz(int number) {

		for (int i = 1; i <= number; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("This number " + i + " is FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("This number " + i + " is Fizz");
			} else if (i % 5 == 0) {
				System.out.println("This number " + i + " is Buzz");
			} else {
				System.out.println("This number " + i + " is not Fizz or Buzz or FizzBuzz");
			}
		}

	}

	public static void swapTwoInteger(int a, int b) {
		// a = 10, b=30
		a = a + b; // -> a = 40, b=30
		b = a - b; // -> a = 40, b=10
		a = a - b; // -> a = 30, b=10
	}

	public static void reverseInteger(int number) {

		int result = 0;
		for (int i = 0; number > 0; i++) {
			result = result * 10 + number % 10;
			number = number / 10;
		}
		System.out.println(result);

	}

	public static void reverseInteger_101(int number) {

		String t = number + "";

		for (int i = t.length() - 1; i >= 0; i--) {
			System.out.print(t.charAt(i));
		}

	}

	public static void reverseString_3(String text) {

//		subString( 21, 22     ); ->K
//		subString(  0,1       ); ->I

		for (int i = text.length() - 1; i >= 0; i--) {
			System.out.print(text.substring(i, i + 1));
		}

	}

	public static void reverseString_2(String text) {

		for (int i = text.length() - 1; i >= 0; i--) {
			System.out.print(text.charAt(i));
		}

	}

	public static void reverseString_1(String text) {

		String[] texts = text.split("");
		char[] t = text.toCharArray();

		for (int i = texts.length - 1; i >= 0; i--) {

			System.out.print(texts[i]);

		}

	}

}
