package uk.co.jimbodev.universitymarkcalculator.service;

import com.sun.javafx.charts.Legend;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import javafx.scene.layout.Region;
import uk.co.jimbodev.universitymarkcalculator.model.Module;
import java.util.List;

public class ModuleResultsChartService
{
	private static final String EXAM_SERIES_LABEL = "Exam";
	private static final String CW_SERIES_LABEL = "Coursework";
	private static final String TOTAL_MARK_LABEL = "(Total)";

	private static final String FIRST_CLASS_LEGEND_LABEL = "1st";
	private static final String UPPER_SECOND_CLASS_LEGEND_LABEL = "2:1";
	private static final String LOWER_SECOND_CLASS_LEGEND_LABEL = "2:2";
	private static final String THIRD_CLASS_LEGEND_LABEL = "3rd";
	private static final String COMPENSATABLE_CLASS_LEGEND_LABEL = "Compensatable Fail";
	private static final String FAIL_LEGEND_LABEL = "Fail";

	private static final int LEGEND_ITEM_WIDTH_HEIGHT = 15;

	private static final String EXAM_STYLE = "-fx-bar-fill: #00008B";
	private static final String CW_STYLE = "-fx-bar-fill: #ADD8E6";
	private static final String EXAM_LEGEND_STYLE = "-fx-background-color: #00008B";
	private static final String CW_LEGEND_STYLE = "-fx-background-color: #ADD8E6";

	private static final String FAIL_STYLE = "-fx-bar-fill: #FF0000";
	private static final String FAIL_LEGEND_STYLE = "-fx-background-color: #FF0000";
	private static final String COMPENSATABLE_FAIL_STYLE = "-fx-bar-fill: #FFCCBB";
	private static final String COMPENSATABLE_FAIL_LEGEND_STYLE = "-fx-background-color: #FFCCBB";
	private static final String THIRD_CLASS_STYLE = "-fx-bar-fill: #cd7f32";
	private static final String THIRD_CLASS_LEGEND_STYLE = "-fx-background-color: #cd7f32";
	private static final String LOWER_SECOND_CLASS_STYLE = "-fx-bar-fill: #C0C0C0";
	private static final String LOWER_SECOND_CLASS_LEGEND_STYLE = "-fx-background-color: #C0C0C0";
	private static final String UPPER_SECOND_CLASS_STYLE = "-fx-bar-fill: #FFD700";
	private static final String UPPER_SECOND_CLASS_LEGEND_STYLE = "-fx-background-color: #FFD700";
	private static final String FIRST_CLASS_STYLE = "-fx-bar-fill: #6600CC";
	private static final String FIRST_CLASS_LEGEND_STYLE = "-fx-background-color: #6600CC";

	private static final String X_AXIS_LABEL = "Module";
	private static final String Y_AXIS_LABEL = "Mark(%)";
	private static final String CHART_TITLE = "Your Module Marks";

	private static final int CHART_WIDTH = 600;
	private static final int CHART_HEIGHT = 400;

	public Chart createBarChart(List<Module> modules)
	{
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(Y_AXIS_LABEL);

		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel(X_AXIS_LABEL);


		XYChart.Series examSeries = new XYChart.Series();

		examSeries.setName(EXAM_SERIES_LABEL);

		XYChart.Series courseworkSeries = new XYChart.Series();
		courseworkSeries.setName(CW_SERIES_LABEL);

		XYChart.Series totalMarkSeries = new XYChart.Series();

		ObservableList<String> moduleNames = FXCollections.observableArrayList();

		for(Module module : modules)
		{
			moduleNames.add(module.getCode());
			moduleNames.add(module.getCode() + TOTAL_MARK_LABEL);

			if(!module.getExamWeightedMark().isNaN())
			{
				XYChart.Data examData = new XYChart.Data(module.getCode(), Double.valueOf(module.getExamWeightedMark()));
				setBarColor(examData, EXAM_STYLE);
				examSeries.getData().add(examData);
			}
			if(!module.getCourseworkWeightedMark().isNaN())
			{
				XYChart.Data courseworkData = new XYChart.Data(module.getCode(), Double.valueOf(module.getCourseworkWeightedMark()));
				setBarColor(courseworkData, CW_STYLE);
				courseworkSeries.getData().add(courseworkData);
			}

			XYChart.Data total = new XYChart.Data(module.getCode() + TOTAL_MARK_LABEL, Double.valueOf(module.getTotalMark()));

			setDataBarColor(total, module);

			totalMarkSeries.getData().add(total);
		}

		xAxis.setCategories(moduleNames);

		StackedBarChart stackedBarChart =
				new StackedBarChart<>(xAxis, yAxis);

		stackedBarChart.setTitle(CHART_TITLE);
		stackedBarChart.setMinSize(CHART_WIDTH, CHART_HEIGHT);
		stackedBarChart.setMaxSize(CHART_WIDTH, CHART_HEIGHT);

		stackedBarChart.getData().addAll(examSeries, courseworkSeries, totalMarkSeries);
		
		updateChartLegend(stackedBarChart);

		return stackedBarChart;
	}

	private Legend updateChartLegend(StackedBarChart stackedBarChart)
	{
		Legend legend = (Legend)stackedBarChart.lookup(".chart-legend");

		legend.getItems().clear();

		Legend.LegendItem examItem = new Legend.LegendItem(EXAM_SERIES_LABEL, createColouredRegionNode(EXAM_LEGEND_STYLE));
		Legend.LegendItem courseworkItem = new Legend.LegendItem(CW_SERIES_LABEL, createColouredRegionNode(CW_LEGEND_STYLE));
		Legend.LegendItem firstClassItem = new Legend.LegendItem(FIRST_CLASS_LEGEND_LABEL, createColouredRegionNode(FIRST_CLASS_LEGEND_STYLE));
		Legend.LegendItem upperSecondClassItem = new Legend.LegendItem(UPPER_SECOND_CLASS_LEGEND_LABEL, createColouredRegionNode(UPPER_SECOND_CLASS_LEGEND_STYLE));
		Legend.LegendItem lowerSecondClassItem = new Legend.LegendItem(LOWER_SECOND_CLASS_LEGEND_LABEL, createColouredRegionNode(LOWER_SECOND_CLASS_LEGEND_STYLE));
		Legend.LegendItem thirdClassItem = new Legend.LegendItem(THIRD_CLASS_LEGEND_LABEL, createColouredRegionNode(THIRD_CLASS_LEGEND_STYLE));
		Legend.LegendItem compensatableFailItem = new Legend.LegendItem(COMPENSATABLE_CLASS_LEGEND_LABEL, createColouredRegionNode(COMPENSATABLE_FAIL_LEGEND_STYLE));
		Legend.LegendItem failItem = new Legend.LegendItem(FAIL_LEGEND_LABEL, createColouredRegionNode(FAIL_LEGEND_STYLE));

		legend.getItems().addAll(examItem, courseworkItem,
				firstClassItem, upperSecondClassItem,
				lowerSecondClassItem, thirdClassItem,
				compensatableFailItem, failItem);

		return legend;
	}

	private Region createColouredRegionNode(String style)
	{
		Region node = new Region();
		node.setMinSize(LEGEND_ITEM_WIDTH_HEIGHT, LEGEND_ITEM_WIDTH_HEIGHT);
		node.setMaxSize(LEGEND_ITEM_WIDTH_HEIGHT, LEGEND_ITEM_WIDTH_HEIGHT);
		node.setStyle(style);

		return node;
	}

	private XYChart.Data setDataBarColor(XYChart.Data data, Module module)
	{
		data.nodeProperty().addListener((ChangeListener<Node>) (ov, oldNode, newNode) ->
		{
			if (newNode != null)
			{
				if(module.getClassification() == Module.Classification.FAIL)
				{
					newNode.setStyle(FAIL_STYLE);
				}
				else if(module.getClassification() == Module.Classification.COMPENSATABLE_FAIL)
				{
					newNode.setStyle(COMPENSATABLE_FAIL_STYLE);
				}
				else if(module.getClassification() == Module.Classification.THIRD_CLASS)
				{
					newNode.setStyle(THIRD_CLASS_STYLE);
				}
				else if(module.getClassification() == Module.Classification.LOWER_SECOND_CLASS)
				{
					newNode.setStyle(LOWER_SECOND_CLASS_STYLE);
				}
				else if(module.getClassification() == Module.Classification.UPPER_SECOND_CLASS)
				{
					newNode.setStyle(UPPER_SECOND_CLASS_STYLE);
				}
				else if(module.getClassification() == Module.Classification.FIRST_CLASS)
				{
					newNode.setStyle(FIRST_CLASS_STYLE);
				}
			}
		});
		return data;
	}

	private XYChart.Data setBarColor(XYChart.Data data, String style)
	{
		data.nodeProperty().addListener((ChangeListener<Node>) (ov, oldNode, newNode) -> newNode.setStyle(style));

		return data;
	}


}
