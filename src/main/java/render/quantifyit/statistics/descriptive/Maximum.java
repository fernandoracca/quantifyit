package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.MultiValuedOperation;
import render.quantifyit.util.DecimalUtils;

public class Maximum<X extends Decimal> implements MultiValuedOperation<X> {

	@Override
	public X eval(final X... elements) {
		DecimalUtils.notNullOrEmpty(elements);

		X max = elements[0];
		for (X element : elements) {
			if (element.gt(max)) {
				max = element;
			}
		}
		return max;
	}

}
