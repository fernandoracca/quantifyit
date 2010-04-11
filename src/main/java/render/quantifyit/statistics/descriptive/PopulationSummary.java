package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;

public class PopulationSummary<X extends Decimal> extends Summary<X> {
	
	public PopulationSummary(final X... dataSet) {
		super(dataSet);
	}

	@SuppressWarnings("unchecked")
	public X getStandardDeviation() {
		return (X) new StandardDeviation.PopulationStandardDeviation<Decimal>().eval(getDataSet());
	}

	@SuppressWarnings("unchecked")
	public X zScoreFor(final int index) {
		return (X) Dispersion.zScore(dataSet[index], getMean(), getStandardDeviation());
	}
}
