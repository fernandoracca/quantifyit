package render.quantifyit.model.operations;

import java.math.MathContext;
import java.math.RoundingMode;

import render.quantifyit.model.Decimal;

public class Divide {
	
	private final Decimal x;
	private final Decimal y;
	private  	  Integer scaleField;
	private   	  RoundingMode roundingMode;	
	private 	  MathContext mathContext;
	
	public Divide(final int x, final int y) {
		this(Decimal.$(x), Decimal.$(y));
	}
	
	public Divide(final long x, final long y) {
		this(Decimal.$(x), Decimal.$(y));
	}
	
	public Divide(final double x, final double y) {
		this(Decimal.$(x), Decimal.$(y));
	}
	
	public  Divide(final Decimal dividend, final Decimal divisor) {
		if(divisor.isZero()) {
			if(dividend.isZero()) {
				throw new ArithmeticException("Division undefined: 0 / 0 is Not a Number");
			}
			throw new ArithmeticException(String.format("Divide by zero exception: %s / 0", dividend));
		}
		this.x = dividend;
		this.y = divisor;
	}
	public Divide precision(final int precision) {
		this.mathContext = new MathContext(precision);
		return this;
	}
	


	public Divide scale(final Integer scale) {
		this.scaleField = scale;
		return this;
	}

	public Divide round(final RoundingMode roundingMode) {
		this.roundingMode = roundingMode;
		return this;
	}
	
	public Divide halfEven() {
		this.roundingMode = RoundingMode.HALF_EVEN;
		return this;
	}
	
	public Divide halfUp() {
		this.roundingMode = RoundingMode.HALF_UP;
		return this;
	}
	
	public Decimal eval() {
		final Division<Decimal, Decimal> division = new Division<Decimal, Decimal>();
		
		if(mathContext != null ) {
			return division.eval(x, y, mathContext);
		}
		
		final boolean hasScale = scaleField != null;
		final boolean hasRoundingMode = roundingMode != null;
		if (hasScale && hasRoundingMode ) {
			return division.eval(x, y, scaleField, roundingMode);
		}
		if ( hasRoundingMode ) {
			return division.eval(x, y, roundingMode);
		} 
		
		return division.eval(x, y);
	}

}
