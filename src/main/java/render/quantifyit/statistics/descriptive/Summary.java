package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;
import render.quantifyit.util.DecimalUtils;

public abstract class Summary<X extends Decimal> {

	protected final X[] dataSet;

	public Summary(final X... dataSet) {
		DecimalUtils.notNullOrEmpty(dataSet);
		this.dataSet = dataSet;
	}
	
	@SuppressWarnings("unchecked")
	public X getMean() {
		return (X) new Mean().eval(getDataSet());
	}
	
	public abstract X getStandardDeviation();

	public X[] getDataSet() {
		return dataSet;
	}
}
