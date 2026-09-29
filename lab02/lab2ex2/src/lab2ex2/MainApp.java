package lab2ex2;

import java.util.Arrays;

import lab2ex2.util.NumberBox;

public class MainApp {
	
	public static void main(String[] args) {
		
		NumberBox<Double> nd = new NumberBox<>(5.3);
		NumberBox<Double> nd2 = new NumberBox<>(5.3);

		NumberBox<Integer> ni = new NumberBox<Integer>(5);
		
		
		
		System.out.printf("%s%n" , nd.add(ni));
		
		System.out.printf("%s%n" , NumberBox.sum(Arrays.asList(nd,ni)));
		
	}
}