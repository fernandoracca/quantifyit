package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;

public class Dispersion {
	
	private Dispersion() {
	}

	public static Decimal sampleVariance(final Decimal mean, final Decimal... elements) {
		return new Variance.SampleVariance<Decimal>().eval(mean, elements);
	}
	
	public static Decimal populationVariance(final Decimal mean, final Decimal... elements) {
		return new Variance.PopulationVariance<Decimal>().eval(mean, elements);
	}
	
	public static Decimal sampleVariance(final Decimal... elements) {
		return new Variance.SampleVariance<Decimal>().eval(elements);
	}
	
	public static Decimal populationVariance(final Decimal... elements) {
		return new Variance.PopulationVariance<Decimal>().eval(elements);
	}

	public static Decimal sampleStandardDeviation(final Decimal mean, final Decimal... elements) {
		return new StandardDeviation.SampleStandardDeviation<Decimal>().eval(mean, elements);
	}
	
	public static Decimal sampleStandardDeviation(final Decimal... elements) {
		return new StandardDeviation.SampleStandardDeviation<Decimal>().eval(elements);
	}
	
	public static Decimal populationStandardDeviation(final Decimal mean, final Decimal... elements) {
		return new StandardDeviation.PopulationStandardDeviation<Decimal>().eval(mean, elements);
	}
	
	public static Decimal populationStandardDeviation(final Decimal... elements) {
		return new StandardDeviation.PopulationStandardDeviation<Decimal>().eval(elements);
	}

	public static Decimal sd2Var(final Decimal standardDeviation) {
		return standardDeviation.square();
	}

	public static Decimal var2Sd(final Decimal variance) {
		if(variance.isNegative()) {
			throw new IllegalArgumentException("Please give a non negative number.");
		}
		return variance.squareRoot();
	}
	
	public static Decimal min(final Decimal... elements) {
		return new Minimum<Decimal>().eval(elements);
	}

	public static Decimal max(final Decimal... elements) {
		return new Maximum<Decimal>().eval(elements);

	}
		
	public static Decimal range(final Decimal... elements) {
		return new Range<Decimal>().eval(elements);
	}
	
	/**
	 * z = (x - μ)/ σ
	 */
	public static Decimal zScore(final Decimal element, 
			final Decimal populationMean, final Decimal populationStandardDeviation) {
		final Decimal delta = element.minus(populationMean);
		return delta.divideBy(populationStandardDeviation);
	}
	
}
