package render.quantifyit.statistics.descriptive;

import render.quantifyit.model.Decimal;
import render.quantifyit.util.DecimalUtils;

public abstract class Summary {

    protected final transient Decimal[] dataSet;

    public Summary(final Decimal... dataSet) {
        DecimalUtils.notNullOrEmpty(dataSet);
        this.dataSet = dataSet;
    }

    public Decimal getMean() {
        return Average.mean(getDataSet());
    }

    public abstract Decimal getStandardDeviation();

    /**
     * getDataSet.
     * 
     * @return returns a copy of internal dataset structure.
     */
    public Decimal[] getDataSet() {
        return dataSet.clone(); // We return a copy to avoid returning the
        // mutable field
    }
}
