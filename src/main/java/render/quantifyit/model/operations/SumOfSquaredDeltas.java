package render.quantifyit.model.operations;

import render.quantifyit.model.Decimal;

/**
 * ∑ (x - μ)^2
 */
public class SumOfSquaredDeltas<X extends Decimal, Y extends Decimal> 
		implements MultipleElements<X, Y>{

	@SuppressWarnings("unchecked")
	public X eval(final X mean, final Y... elements) {
		Decimal sumOfSquaredDeltas = Decimal.ZERO;
		for (Decimal element : elements) {  
			sumOfSquaredDeltas = sumOfSquaredDeltas.plus(element.minus(mean).square());
		}
		return (X) sumOfSquaredDeltas;
	}	
	
}
