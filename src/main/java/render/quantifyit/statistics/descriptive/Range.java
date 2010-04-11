package render.quantifyit.statistics.descriptive;

import java.util.Arrays;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.MultiValuedOperation;
import render.quantifyit.util.DecimalUtils;

public class Range<X extends Decimal> implements MultiValuedOperation<X> {

	@SuppressWarnings("unchecked")
	public X eval(final X... elements) {
		DecimalUtils.notNullOrEmpty(elements);

		Arrays.sort(elements);
		
		return (X) elements[elements.length - 1].minus(elements[0]);
	}
}
