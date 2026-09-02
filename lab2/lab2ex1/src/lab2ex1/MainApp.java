package lab2ex1;

import java.util.*;

import lab2ex1.util.*;

public class MainApp {

	public static void main(String[] args) {
		
		PrintableList<Double> Id = new PrintableList(2.3,5.6);
		
		Id.print();
		
		PrintableList<Integer> li = new PrintableList(14,19,65);
		
		li.print();
	}
}
