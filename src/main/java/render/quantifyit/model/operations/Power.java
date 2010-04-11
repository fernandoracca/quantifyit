package render.quantifyit.model.operations;

import java.math.MathContext;

import render.quantifyit.model.Decimal;

public class Power<X extends Decimal> implements Operation<X> {

	public Decimal eval(final X x, final int power) {
		return Decimal.$(x.asBigDecimal().pow(power));
	}

	public Decimal eval(final X x, final int power, final MathContext roundingCriteria) {
		return Decimal.$(x.asBigDecimal().pow(power, roundingCriteria));
	}
}
