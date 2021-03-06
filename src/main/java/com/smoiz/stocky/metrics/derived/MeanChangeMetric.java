package com.smoiz.stocky.metrics.derived;

import com.smoiz.stocky.metrics.CloseMetric;
import com.smoiz.stocky.metrics.OpenMetric;
import com.smoiz.stocky.stock.NQuotes;

/**
 * This metric is mean change from the open of the NQuote.
 */
public class MeanChangeMetric extends NQStockMetric {

    public static final String NAME = "mean_change";

    private MeanChangeMetric(double value) {
        super(NAME, value);
    }

    public static NQStockMetric createMetric(NQuotes nQuotes) {
        double avg_close = average(CloseMetric.NAME, nQuotes);
        double open = nQuotes.getQuotes().get(0).getMetric(OpenMetric.NAME).getValue();
        double change = (avg_close - open) / open;
        return new MeanChangeMetric(change);
    }
}
