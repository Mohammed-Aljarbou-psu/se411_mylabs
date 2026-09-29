package lab2ex3.util;

public class PipeLine<T, R> {

	private final Transformer<T, R> transformer;

	private PipeLine(Transformer<T, R> transformer) {
		this.transformer = transformer;
	}

	// Starts a pipeline whose input and output types are both T (identity transformer).
	public static <T> PipeLine<T, T> start() {
		return new PipeLine<>(input -> input);
	}

	// Adds a transformation step. The step can keep the type the same (R -> R)
	// or change it (R -> R2); a new pipeline is returned with the updated output type.
	public <R2> PipeLine<T, R2> addStep(Transformer<R, R2> next) {
		Transformer<T, R> current = this.transformer;
		Transformer<T, R2> combined = input -> next.transform(current.transform(input));
		return new PipeLine<>(combined);
	}

	// Runs every transformation added so far, in order, on the given input.
	public R execute(T input) {
		return transformer.transform(input);
	}
}
