package lab2ex2.util;
import java.util.List;

public class NumberBox<T extends Number> {
	
	private T element;
	
	public NumberBox() {
		
	}
	
	public NumberBox(T data) {
		if (data == null) throw new IllegalArgumentException("data argument connot be null");
		
		element = data;
	}
	
	public double add(NumberBox<?> other ){
		return this.element.doubleValue() + other.getElement().doubleValue();
	}
	
	public static double sum(List<NumberBox<?>> lst) {
	if (lst == null) throw new IllegalArgumentException("lst connot be null");
	double sum = 0;
	for(NumberBox<?> n:lst) {
		sum += n.getElement().doubleValue();
	}
	return sum;
	
}	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
}
	
	

