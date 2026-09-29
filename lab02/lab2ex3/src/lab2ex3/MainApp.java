package lab2ex3;

import lab2ex3.util.PipeLine;

public class MainApp {

	public static void main(String[] args) {

		// In-place transformation: String -> String (trim + uppercase)
		// Type-changing transformations: String -> Integer -> Double
		PipeLine<String, Double> pipeline = PipeLine.<String>start()
				.addStep(String::trim)
				.addStep(String::toUpperCase)
				.addStep(String::length)
				.addStep(len -> len * 2.5);

		Double result = pipeline.execute("  hello world  ");
		System.out.println("Result: " + result);

		PipeLine<Integer, Integer> mathPipeline = PipeLine.<Integer>start()
				.addStep(n -> n + 10)
				.addStep(n -> n * 2);

		System.out.println("Math result: " + mathPipeline.execute(5));
	}
}
