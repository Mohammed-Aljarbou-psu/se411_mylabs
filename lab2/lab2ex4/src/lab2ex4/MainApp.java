package lab2ex4;

import java.util.Arrays;
import java.util.List;

public class MainApp {

	// Wildcard <?> : accepts a list of any (unknown) type, only for reading/printing.
	public static void printList(List<?> list) {
		for (Object item : list) {
			System.out.println(item);
		}
	}

	// Bounded wildcard <? extends Number> : accepts a list of any Number subtype.
	public static double sumNumbers(List<? extends Number> list) {
		double sum = 0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ali", "Sara", "Omar");
		printList(names);

		List<Integer> ints = Arrays.asList(1, 2, 3);
		printList(ints);
		System.out.println("Sum of ints: " + sumNumbers(ints));

		List<Double> doubles = Arrays.asList(1.5, 2.5, 3.0);
		printList(doubles);
		System.out.println("Sum of doubles: " + sumNumbers(doubles));
	}
}
