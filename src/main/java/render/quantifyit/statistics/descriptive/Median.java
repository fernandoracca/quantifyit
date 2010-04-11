package render.quantifyit.statistics.descriptive;

import java.util.Arrays;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.MultiValuedOperation;
import render.quantifyit.util.DecimalUtils;

/**
 * A median is described as the number separating the higher half of a sample, 
 * a population, or a probability distribution, from the lower half. 
 * The median of a finite list of numbers can be found by arranging all the 
 * observations from lowest value to highest value and picking the middle one. 
 * If there is an even number of observations, the median is not unique, so one 
 * often takes the mean of the two middle values. At most half the population have 
 * values less than the median and at most half have values greater than the median.
 * 
 * @see "http://en.wikipedia.org/wiki/Median"
 */
public class Median<X extends Decimal> implements MultiValuedOperation<X> {

	@SuppressWarnings("unchecked")
	public X eval(final X... elements) {
		DecimalUtils.notNullOrEmpty(elements);
		Arrays.sort(elements);
		Decimal median = Decimal.ZERO;
		final int medianPosition = elements.length / 2;
		
		if (elements.length % 2 == 0) {
			median = (elements[medianPosition - 1].plus(elements[medianPosition])).halve(); 
		} else {
			median = elements[medianPosition];
		}
		return (X) median;
	}
	
}
