package uk.co.jimbodev.universitymarkcalculator.service;

import com.sun.javafx.charts.Legend;
import javafx.scene.chart.Chart;
import javafx.scene.chart.StackedBarChart;
import org.junit.jupiter.api.Test;
import uk.co.jimbodev.universitymarkcalculator.model.Assessment;
import uk.co.jimbodev.universitymarkcalculator.model.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleResultsChartServiceTest
{
	private ModuleResultsChartService moduleResultsChartService = new ModuleResultsChartService();
	private List<Module> modules = createModuleList();

	@Test
	public void testLegendContainsAllItems()
	{
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		Chart chart = moduleResultsChartService.createBarChart(modules);
		Legend legend = (Legend)chart.lookup(".chart-legend");

		assertEquals(8, legend.getItems().size());
		assertEquals("Exam", legend.getItems().get(0).getText());
		assertEquals("-fx-background-color: #00008B", legend.getItems().get(0).getSymbol().getStyle());

		assertEquals("Coursework", legend.getItems().get(1).getText());
		assertEquals("-fx-background-color: #ADD8E6", legend.getItems().get(1).getSymbol().getStyle());

		assertEquals("1st", legend.getItems().get(2).getText());
		assertEquals("-fx-background-color: #6600CC", legend.getItems().get(2).getSymbol().getStyle());

		assertEquals("2:1", legend.getItems().get(3).getText());
		assertEquals("-fx-background-color: #FFD700", legend.getItems().get(3).getSymbol().getStyle());

		assertEquals("2:2", legend.getItems().get(4).getText());
		assertEquals("-fx-background-color: #C0C0C0", legend.getItems().get(4).getSymbol().getStyle());

		assertEquals("3rd", legend.getItems().get(5).getText());
		assertEquals("-fx-background-color: #cd7f32", legend.getItems().get(5).getSymbol().getStyle());

		assertEquals("Compensatable Fail", legend.getItems().get(6).getText());
		assertEquals("-fx-background-color: #FFCCBB", legend.getItems().get(6).getSymbol().getStyle());

		assertEquals("Fail", legend.getItems().get(7).getText());
		assertEquals("-fx-background-color: #FF0000", legend.getItems().get(7).getSymbol().getStyle());
	}

	@Test
	public void testTotalMarkBarsRenderedInCorrectColor()
	{
		com.sun.javafx.application.PlatformImpl.startup(()->{});

		StackedBarChart chart = (StackedBarChart)moduleResultsChartService.createBarChart(modules);

		assertEquals("Your Module Marks", chart.getTitle());
		assertEquals("Module", chart.getXAxis().getLabel());
		assertEquals("Mark(%)", chart.getYAxis().getLabel());

	}

	private List<Module> createModuleList()
	{
		List<Assessment> firstClassModuleExams = new ArrayList<>(Arrays.asList(
				new Assessment("exam1", Assessment.Type.EXAM, 0.2, 70.00),
				new Assessment("exam2", Assessment.Type.EXAM, 0.6, 70.00)
		));

		List<Assessment> firstClassModuleCoursework = new ArrayList<>(Arrays.asList(
				new Assessment("cw1", Assessment.Type.COURSEWORK, 0.1, 70.00),
				new Assessment("cw2", Assessment.Type.COURSEWORK, 0.1, 70.00)
		));

		List<Assessment> upperSecondClassModuleExams = new ArrayList<>(Arrays.asList(
				new Assessment("exam1", Assessment.Type.EXAM, 0.4, 65.00),
				new Assessment("exam2", Assessment.Type.EXAM, 0.1, 65.00)
		));

		List<Assessment> upperSecondClassModuleCoursework = new ArrayList<>(Arrays.asList(
				new Assessment("cw1", Assessment.Type.COURSEWORK, 0.1, 55.00),
				new Assessment("cw2", Assessment.Type.COURSEWORK, 0.4, 55.00)
		));

		List<Assessment> lowerSecondClassModuleExams = new ArrayList<>(Arrays.asList(
				new Assessment("exam1", Assessment.Type.EXAM, 0.4, 55.00),
				new Assessment("exam2", Assessment.Type.EXAM, 0.1, 55.00)
		));

		List<Assessment> lowerSecondClassModuleCoursework = new ArrayList<>(Arrays.asList(
				new Assessment("cw1", Assessment.Type.COURSEWORK, 0.1, 45.00),
				new Assessment("cw2", Assessment.Type.COURSEWORK, 0.4, 45.00)
		));

		List<Assessment> thirdClassModuleExams = new ArrayList<>(Arrays.asList(
				new Assessment("exam1", Assessment.Type.EXAM, 0.4, 50.00),
				new Assessment("exam2", Assessment.Type.EXAM, 0.1, 50.00)
		));

		List<Assessment> thirdClassModuleCoursework = new ArrayList<>(Arrays.asList(
				new Assessment("cw1", Assessment.Type.COURSEWORK, 0.1, 40.00),
				new Assessment("cw2", Assessment.Type.COURSEWORK, 0.4, 40.00)
		));

		List<Assessment> compensatableFailIfNonCoreModuleExams = new ArrayList<>(Arrays.asList(
				new Assessment("exam1", Assessment.Type.EXAM, 0.4, 35.00),
				new Assessment("exam2", Assessment.Type.EXAM, 0.1, 35.00)
		));

		List<Assessment> compensatableFailIfNonCoreModuleCoursework = new ArrayList<>(Arrays.asList(
				new Assessment("cw1", Assessment.Type.COURSEWORK, 0.1, 40.00),
				new Assessment("cw2", Assessment.Type.COURSEWORK, 0.4, 40.00)
		));

		List<Assessment> failModuleExams = new ArrayList<>(Arrays.asList(
				new Assessment("exam1", Assessment.Type.EXAM, 0.4, 30.00),
				new Assessment("exam2", Assessment.Type.EXAM, 0.1, 30.00)
		));

		List<Assessment> failModuleCoursework = new ArrayList<>(Arrays.asList(
				new Assessment("cw1", Assessment.Type.COURSEWORK, 0.1, 30.00),
				new Assessment("cw2", Assessment.Type.COURSEWORK, 0.4, 30.00)
		));
		List<Assessment> moduleNoCoursework = new ArrayList<>(Arrays.asList());

		List<Assessment> moduleNoCourseworkExams = new ArrayList<>(Arrays.asList(
				new Assessment("exam1", Assessment.Type.EXAM, 0.5, 80.00),
				new Assessment("exam2", Assessment.Type.EXAM, 0.5, 80.00)
		));

		List<Assessment> moduleNoExam = new ArrayList<>(Arrays.asList());

		List<Assessment> moduleNoExamCoursework = new ArrayList<>(Arrays.asList(
				new Assessment("cw1", Assessment.Type.EXAM, 0.5, 80.00),
				new Assessment("cw2", Assessment.Type.EXAM, 0.5, 80.00)
		));

		List<Module> modules = new ArrayList<>(Arrays.asList(
				new Module("1", "1", false, firstClassModuleExams, firstClassModuleCoursework),
				new Module("2", "2", false, upperSecondClassModuleExams, upperSecondClassModuleCoursework),
				new Module("3", "3", false, lowerSecondClassModuleExams, lowerSecondClassModuleCoursework),
				new Module("4", "4", false, thirdClassModuleExams, thirdClassModuleCoursework),
				new Module("5", "5", false, compensatableFailIfNonCoreModuleExams, compensatableFailIfNonCoreModuleCoursework),
				new Module("6", "6", true, compensatableFailIfNonCoreModuleExams, compensatableFailIfNonCoreModuleCoursework),
				new Module("7", "7", true, failModuleExams, failModuleCoursework),
				new Module("8", "8", true, moduleNoExam, moduleNoExamCoursework),
				new Module("9", "9", true, moduleNoCourseworkExams, moduleNoCoursework)
		));
		return modules;
	}
}
