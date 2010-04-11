package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.MultiValuedOperation;
import render.quantifyit.util.DecimalUtils;

public class Minimum<X extends Decimal> implements MultiValuedOperation<X> {

	public X eval(final X... elements) {
		DecimalUtils.notNullOrEmpty(elements);
		
		X min = elements[0];
		for (X element : elements) {
			if(element.lt(min)) {
				min = element;
			}
		}
		return min;
	}
	
}
