package com.logicbig.example;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
public class LineChartBean {
    @Autowired
    private DataService dataService,dsMin,dsMax;
    private LineChartModel lineModel;
	
	private float prix = 1234.56f ;

	private Double test1 = 10.12;
	
	private Date date1 = new Date();
	
	private Map<String,Double> map = new HashMap <String,Double> ();

    @PostConstruct
    public void init() {
        lineModel = new LineChartModel();
		
        LineChartSeries s = new LineChartSeries();
        s.setLabel("Population");
		dataService.getLineChartData(0).forEach(s::set);
        lineModel.addSeries(s);

        LineChartSeries min = new LineChartSeries();
        min.setLabel("Min");
		dsMin.getLineChartData(1).forEach(min::set);
        lineModel.addSeries(min);
		
        LineChartSeries max = new LineChartSeries();
        max.setLabel("Max");
		dsMax.getLineChartData(2).forEach(max::set);
        lineModel.addSeries(max);
		
        lineModel.setLegendPosition("e");
        Axis y = lineModel.getAxis(AxisType.Y);
        y.setMin(0);
        y.setMax(700);
        y.setTickInterval("100");
        y.setLabel("Millions");

        Axis x = lineModel.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(7);
        x.setTickInterval("1");
        x.setLabel("Number of Years");

    }

    public LineChartModel getLineModel() {
        return lineModel;
    }
	
	public void setTest1(Double test) {
		this.test1=test;
	}
	
	public Double getTest1() {
		return test1;
	}
	public float getPrix() {
		return prix;
	}
	public Date getDate1() {
		return date1;
	}
	
	public void ajaxChange() {
	}
	public void clicChange() {
		System.out.println( "click: " + test1 );
	}

}