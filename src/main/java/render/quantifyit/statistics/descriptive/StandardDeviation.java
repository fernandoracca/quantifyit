package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.MultipleElements;
import render.quantifyit.statistics.descriptive.Variance.PrecaculatedMeanPopulationVariance;
import render.quantifyit.statistics.descriptive.Variance.PrecaculatedMeanSampleVariance;
import render.quantifyit.util.DecimalUtils;

public abstract class StandardDeviation {
	
	protected static class PrecalculatedMeanSampleStandardDeviation 
		<X extends Decimal, Y extends Decimal> implements MultipleElements<X, Y> {

		@SuppressWarnings("unchecked")
		@Override
		public X eval(final X mean, final Y... elements) {
			return (X) new PrecaculatedMeanSampleVariance<X, Y>().eval(mean, elements).squareRoot();
		}
	}
	
	protected static class PrecalculatedMeanPopulationStandardDeviation 
		<X extends Decimal, Y extends Decimal> implements MultipleElements<X, Y> {
		
		@SuppressWarnings("unchecked")
		@Override
		public X eval(final X mean, final Y... elements) {
			return (X) new PrecaculatedMeanPopulationVariance<X, Y>().eval(mean, elements).squareRoot();
		}
	}
	
	public static class SampleStandardDeviation <X extends Decimal>
		extends PrecalculatedMeanSampleStandardDeviation<X, X> {
		
		@SuppressWarnings("unchecked")
		public X eval(final X... elements) {
			DecimalUtils.notNullOrEmpty(elements);
			if(elements.length == 1) {
				return (X) Decimal.ZERO;
			}
			return super.eval(new Mean<X>().eval(elements), elements);
		}
	}
	
	public static class PopulationStandardDeviation <X extends Decimal>
		extends PrecalculatedMeanPopulationStandardDeviation<X, X> {
	
		@SuppressWarnings("unchecked")
		public X eval(final X... elements) {
			if(elements.length == 1) {
				return (X) Decimal.ZERO;
			}
			return super.eval(new Mean<X>().eval(elements), elements);
		}
	}
}