package uk.co.jimbodev.universitymarkcalculator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.StackedBarChart;
import javafx.stage.Stage;
import uk.co.jimbodev.universitymarkcalculator.input.AssessmentMarkInput;
import uk.co.jimbodev.universitymarkcalculator.model.Module;
import uk.co.jimbodev.universitymarkcalculator.service.MarkCalculatorService;
import uk.co.jimbodev.universitymarkcalculator.service.ModuleResultsChartService;

import java.util.List;

public class UniversityMarkCalculator  extends Application
{
	private static final String STAGE_TITLE = "University Mark Calculator";
	private static final int SCENE_WIDTH = 600;
	private static final int SCENE_HEIGHT = 400;

	public static void main(String[] args)
	{
		launch();
	}

	@Override
	public void start(Stage stage)
	{
		List<Module> modules = new AssessmentMarkInput().inputMarksForAllFirstYearAssessments();

		modules = new MarkCalculatorService().calculateAllModuleMarks(modules);

		Chart moduleResultsChart = new ModuleResultsChartService().createBarChart(modules);

		Group root = new Group();
		root.getChildren().addAll(moduleResultsChart);

		Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

		stage.setTitle(STAGE_TITLE);
		stage.setScene(scene);
		stage.show();
	}
}
