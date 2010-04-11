package render.quantifyit.model.operations;

import render.quantifyit.model.Decimal;

public interface MultiValuedOperation<X extends Decimal> extends Operation<X> {

	X eval(X... elements);
}
