package render.quantifyit.model.operations;

import java.math.MathContext;

import render.quantifyit.model.Decimal;

public class SquareRoot<X extends Decimal> implements Operation<X> {

	public Decimal eval(final int squared) {
		return Decimal.$(Math.sqrt(squared));
	}
	
	public Decimal eval(final double squared) {
		return Decimal.$(Math.sqrt(squared));
	}
	
	public Decimal eval(final Decimal squared) {
		return Decimal.$(Math.sqrt(squared.asDouble()));
	}
	
	public Decimal eval(final Decimal squared, final MathContext roundingCriteria) {
		return Decimal.$(Math.sqrt(squared.asDouble()), roundingCriteria);
	}
}
