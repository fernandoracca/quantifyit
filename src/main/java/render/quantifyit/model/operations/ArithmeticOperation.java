package render.quantifyit.model.operations;

import java.math.MathContext;

import render.quantifyit.model.Decimal;

public interface ArithmeticOperation<X extends Decimal, Y extends Decimal>
	extends Operation<X> {

	X eval(X x, Y y);
	 
	X eval(X x, Y y, MathContext roundingCriteria);
}
