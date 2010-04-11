package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;

public class Average {
	
	private Average() {
	}
	
	public static <X extends Decimal> X mean(final X ... elements) {
		return new Mean<X>().eval(elements);
	}
	
	
	/**
	 * @param elements 
	 * @return the median of a series of numbers in Decimal
	 */
	public static <X extends Decimal> X median(final X... elements) {
		return new Median<X>().eval(elements);
	}

	/**
	 * In statistics, the mode is the value that occurs the most frequently in a data 
	 * set or a probability distribution.
	 * 
	 * @param elements 
	 * @return the mode
	 */
	public static <X extends Decimal> X[] mode(final X... elements) {
		return new Mode<X>().eval(elements);
	}

}
