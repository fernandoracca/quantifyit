package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.MultiValuedOperation;
import render.quantifyit.util.DecimalUtils;

public class Mean<X extends Decimal> implements MultiValuedOperation<X> {

	/**
	 * The arithmetic mean (or simply the mean) of a list of numbers is the sum of all 
	 * of the list divided by the number of items in the list. 
	 * Returns NaN if 0 elements.
	 * @param elements 
	 * @return the mean value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public X eval(final X... elements) {
		DecimalUtils.notNullOrEmpty(elements);	
		int count = 0;
		Decimal sum = Decimal.ZERO;
		for (Decimal element : elements) {
			sum = sum.plus(element);
			count++;
		}
		return (X) sum.divideBy(count);
	}
}
