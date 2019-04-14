package com.company.model.dataset;

import com.company.model.account.Data;
import org.jfree.data.xy.*;

public class DataSet {

    public static XYDataset createDataSet(Data data, int counter) {
        final XYSeries series2 = new XYSeries("Attempts in the day");
        for (int i = 0; i < counter; i++)
            series2.add(data.getAttemptElement(i) + 0.0, i + 1.0);

        final XYSeriesCollection dataSet = new XYSeriesCollection();
        dataSet.addSeries(series2);

        return dataSet;
    }
}

