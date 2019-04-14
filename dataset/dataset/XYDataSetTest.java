package dataset;

import com.company.model.account.Data;
import com.company.model.dataset.DataSet;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class XYDataSetTest {

    @Test
    public void XYDataSet() {
        final XYSeries series2 = new XYSeries("Attempts in the day");
        series2.add(0.0, 1.0);
        series2.add(0.0, 2.0);
        series2.add(0.0, 3.0);
        final XYSeriesCollection dataSet = new XYSeriesCollection();
        dataSet.addSeries(series2);

        assertEquals(dataSet, DataSet.createDataSet(new Data(), 3));
    }

    @Test
    public void XYDataSetNeg() {
        final XYSeries series2 = new XYSeries("Attempts in the day");
        series2.add(3.0, 1.0);
        series2.add(2.0, 2.0);
        series2.add(1.0, 3.0);
        final XYSeriesCollection dataSet = new XYSeriesCollection();
        dataSet.addSeries(series2);

        assertNotEquals(dataSet, DataSet.createDataSet(new Data(), 3));
    }
}
