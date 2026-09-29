package lab2ex1.util;

import java.util.*;

public class PrintableList<T>{
	
	private List<T> elements;
	
	public PrintableList() {
		elements = new ArrayList<T>();
				
	}
	
	public PrintableList(T... arr) {
		elements = Arrays.asList(arr);
	}
	
	public void print() {
		for(T e: elements) {
			System.out.printf("%S", e);
		}
	}
}