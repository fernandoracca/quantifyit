package render.quantifyit.model.operations;

import java.math.MathContext;
import java.math.RoundingMode;

import render.quantifyit.model.Decimal;

public class Division<X extends Decimal, Y extends Decimal> implements ArithmeticOperation<X, Y>{

	@SuppressWarnings("unchecked")
	@Override
	public X eval(final X x, final Y y) {
		return (X) Decimal.$(x.asBigDecimal().divide(y.asBigDecimal()));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public X eval(final X x, final Y y, final MathContext roundingCriteria) {
		return (X) Decimal.$(x.asBigDecimal().divide(y.asBigDecimal(),roundingCriteria));
	}
	
	public Decimal eval(final X x, final X y, final int scale) {
		return Decimal.$(x.asBigDecimal().divide(y.asBigDecimal(), scale));
	}
	
	public Decimal eval(final X x, final Y y, final RoundingMode roundingMode) {
		return Decimal.$(x.asBigDecimal().divide(y.asBigDecimal(), roundingMode));
	}
	
	public Decimal eval(final X x, final Y y, final int scale, final RoundingMode roundingMode) {
		return Decimal.$(x.asBigDecimal().divide(y.asBigDecimal(), scale, roundingMode));
	}
	
}
