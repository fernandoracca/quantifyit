package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;

public class SampleSummary<X extends Decimal> extends Summary<X> {

	public SampleSummary(final X... dataSet) {
		super(dataSet);
	}
	
	@SuppressWarnings("unchecked")
	public X getStandardDeviation() {
		return (X) new StandardDeviation.SampleStandardDeviation<Decimal>().eval(getMean(), getDataSet());
	}
}
