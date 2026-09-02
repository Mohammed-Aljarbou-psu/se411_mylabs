package edu.psu.se411.model;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void default_constructor_creates_usable_stack() {
		Stack<String> stringStack = new Stack<>();

		stringStack.push("value");

		assertEquals("value", stringStack.pop());
	}

	@Test
	void positive_capacity_constructor_creates_usable_stack() {
		Stack<Integer> intStack = new Stack<>(2);

		intStack.push(1);
		intStack.push(2);

		assertEquals(2, intStack.pop());
		assertEquals(1, intStack.pop());
	}

	@org.junit.jupiter.params.ParameterizedTest
	@org.junit.jupiter.params.provider.ValueSource(ints = { 0, -1, Integer.MIN_VALUE })
	void non_positive_capacity_uses_fallback_capacity(int capacity) {
		Stack<String> stringStack = new Stack<>(capacity);

		stringStack.push("");

		assertEquals("", stringStack.pop());
	}

	@Test
	void push_accepts_null_and_preserves_lifo_state() {
		Stack<String> stringStack = new Stack<>();
		stringStack.push(null);
		stringStack.push("");

		assertEquals("", stringStack.pop());
		assertEquals(null, stringStack.pop());
	}

	@Test
	void pop_returns_elements_in_reverse_order_across_multiple_calls() {
		Stack<Integer> intStack = new Stack<>();
		intStack.push(Integer.MIN_VALUE);
		intStack.push(0);
		intStack.push(Integer.MAX_VALUE);

		assertEquals(Integer.MAX_VALUE, intStack.pop());
		assertEquals(0, intStack.pop());
		assertEquals(Integer.MIN_VALUE, intStack.pop());
	}

	@Test
	void pop_empty_stack_throws_exact_exception_and_message() {
		Stack<String> stringStack = new Stack<>();

		NoSuchElementException exception = assertThrows(
				NoSuchElementException.class,
				stringStack::pop
		);

		assertEquals("Stack is empty, cannot pop", exception.getMessage());
	}

	@Test
	void failed_pop_does_not_change_empty_stack_state() {
		Stack<String> stringStack = new Stack<>();

		assertThrows(NoSuchElementException.class, stringStack::pop);
		assertThrows(NoSuchElementException.class, stringStack::pop);
}
}