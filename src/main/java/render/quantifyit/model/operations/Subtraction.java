package render.quantifyit.model.operations;

import java.math.MathContext;

import render.quantifyit.model.Decimal;

public class Subtraction<X extends Decimal, Y extends Decimal> implements ArithmeticOperation<X, Y> {

	@SuppressWarnings("unchecked")
	@Override
	public X eval(final X x, final Y y) {
		return (X) Decimal.$(x.asBigDecimal().subtract(y.asBigDecimal()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public X eval(final X x, final Y y, final MathContext roundingCriteria) {
		return (X) Decimal.$(x.asBigDecimal().subtract(y.asBigDecimal(), roundingCriteria));
	}
}
