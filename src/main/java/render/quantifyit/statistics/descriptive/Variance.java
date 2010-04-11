package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.MultipleElements;
import render.quantifyit.model.operations.SumOfSquaredDeltas;


public abstract class Variance {

	protected abstract static class VarianceInitialCalculation
		<X extends Decimal, Y extends Decimal> implements MultipleElements<X, Y> {
		
		@SuppressWarnings("unchecked")
		@Override
		public X eval(final X mean, final Y... elements) {
			if(elements.length == 1) {
				return (X) Decimal.ZERO;
			}
			return (X) new SumOfSquaredDeltas().eval(mean, elements);
		}
		
	}
	
	protected static class PrecaculatedMeanSampleVariance<X extends Decimal, Y extends Decimal> 
			extends VarianceInitialCalculation<X, Y> {

		@SuppressWarnings("unchecked")
		@Override
		public X eval(final X mean, final Y... elements) {
			if(elements.length == 1) {
				return (X) Decimal.ZERO;
			}
			return (X) super.eval(mean, elements).divideBy(elements.length - 1);
		}
		
	}
	
	protected static class PrecaculatedMeanPopulationVariance<X extends Decimal, Y extends Decimal> 
			extends VarianceInitialCalculation<X, Y> {
		
		@SuppressWarnings("unchecked")
		@Override	
		public X eval(final X mean, final Y... elements) {
			return (X) super.eval(mean, elements).divideBy(elements.length);
		}
		
	}
	
	public static class SampleVariance <X extends Decimal> 
		extends PrecaculatedMeanSampleVariance<X,X> {
		
		public X eval(final X... elements) {
			return super.eval(new Mean<X>().eval(elements), elements);
		}
	}
	
	public static class PopulationVariance <X extends Decimal> 
		extends PrecaculatedMeanPopulationVariance<X,X> {
		
		public X eval(final X... elements) {
			return super.eval(new Mean<X>().eval(elements), elements);
		}
	}
	
}
