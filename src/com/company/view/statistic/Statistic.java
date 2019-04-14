package com.company.view.statistic;

import com.company.model.account.Data;
import com.company.model.dataset.DataSet;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;

public class Statistic extends JFrame {
    private static final long serialVersionUID = 1L;

    public Statistic(Data data, int counter) {
        super("Statistic Of " + data.getLogin());

        XYDataset dataSet = DataSet.createDataSet(data, counter);
        JFreeChart chart = createChart(dataSet, data);
        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(500, 450));
        setContentPane(chartPanel);
    }

    private JFreeChart createChart(XYDataset dataSet, Data data) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Statistic Of " + data.getLogin(),
                null,
                null,
                dataSet,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(new Color(232, 232, 232));

        plot.setDomainGridlinePaint(Color.gray);
        plot.setRangeGridlinePaint(Color.gray);
        plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));

        ValueAxis axis = plot.getDomainAxis();
        axis.setAxisLineVisible(false);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesPaint(1, Color.orange);
        renderer.setSeriesStroke(1, new BasicStroke(2.5f));
        plot.setRenderer(renderer);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setAxisLineVisible(false);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }
}
