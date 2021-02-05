package uk.co.jimbodev.universitymarkcalculator.service;

import org.junit.jupiter.api.Test;
import uk.co.jimbodev.universitymarkcalculator.model.Assessment;
import uk.co.jimbodev.universitymarkcalculator.model.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkCalculatorServiceTest
{
	private MarkCalculatorService markCalculatorService = new MarkCalculatorService();

	private List<Module> modules = createModuleList();

	@Test
	public void testCorrectTotalExamMarkProvidedForAllModules()
	{

		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(70.00, modules.get(0).getExamMark());
		assertEquals(65.00, modules.get(1).getExamMark());
		assertEquals(55.00, modules.get(2).getExamMark());
		assertEquals(50.00, modules.get(3).getExamMark());
		assertEquals(35.00, modules.get(4).getExamMark());
		assertEquals(35.00, modules.get(5).getExamMark());
		assertEquals(30.00, modules.get(6).getExamMark());
		assertEquals(Double.NaN, modules.get(7).getExamMark());
		assertEquals(80.00, modules.get(8).getExamMark());
	}

	@Test
	public void testCorrectTotalWeightedExamMarkProvidedForAllModules()
	{

		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(56.00, modules.get(0).getExamWeightedMark());
		assertEquals(32.5, modules.get(1).getExamWeightedMark());
		assertEquals(27.5, modules.get(2).getExamWeightedMark());
		assertEquals(25.00, modules.get(3).getExamWeightedMark());
		assertEquals(17.5, modules.get(4).getExamWeightedMark());
		assertEquals(17.5, modules.get(5).getExamWeightedMark());
		assertEquals(15.00, modules.get(6).getExamWeightedMark());
		assertEquals(0.00, modules.get(7).getExamWeightedMark());
		assertEquals(80.00, modules.get(8).getExamWeightedMark());
	}

	@Test
	public void testCorrectTotalCourseworkMarkProvidedForAllModules()
	{

		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(70.00, modules.get(0).getCourseworkMark());
		assertEquals(55.00, modules.get(1).getCourseworkMark());
		assertEquals(45.00, modules.get(2).getCourseworkMark());
		assertEquals(40.00, modules.get(3).getCourseworkMark());
		assertEquals(40.00, modules.get(4).getCourseworkMark());
		assertEquals(40.00, modules.get(5).getCourseworkMark());
		assertEquals(30.00, modules.get(6).getCourseworkMark());
		assertEquals(80.00, modules.get(7).getCourseworkMark());
		assertEquals(Double.NaN, modules.get(8).getCourseworkMark());
	}

	@Test
	public void testCorrectTotalWeightedCourseworkMarkProvidedForAllModules()
	{

		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(14.00, modules.get(0).getCourseworkWeightedMark());
		assertEquals(27.5, modules.get(1).getCourseworkWeightedMark());
		assertEquals(22.5, modules.get(2).getCourseworkWeightedMark());
		assertEquals(20.00, modules.get(3).getCourseworkWeightedMark());
		assertEquals(20.00, modules.get(4).getCourseworkWeightedMark());
		assertEquals(20.00, modules.get(5).getCourseworkWeightedMark());
		assertEquals(15.00, modules.get(6).getCourseworkWeightedMark());
		assertEquals(80.00, modules.get(7).getCourseworkWeightedMark());
		assertEquals(0.00, modules.get(8).getCourseworkWeightedMark());
	}

	@Test
	public void testCorrectTotalMarkProvidedForAllModules()
	{

		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(70.00, modules.get(0).getTotalMark());
		assertEquals(60.00, modules.get(1).getTotalMark());
		assertEquals(50.00, modules.get(2).getTotalMark());
		assertEquals(45.00, modules.get(3).getTotalMark());
		assertEquals(37.5, modules.get(4).getTotalMark());
		assertEquals(37.5, modules.get(5).getTotalMark());
		assertEquals(30.00, modules.get(6).getTotalMark());
		assertEquals(80.00, modules.get(7).getTotalMark());
		assertEquals(80.00, modules.get(8).getTotalMark());
	}

	@Test
	public void testFirstClassModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.FIRST_CLASS, modules.get(0).getClassification());
	}

	@Test
	public void testUpperSecondClassModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.UPPER_SECOND_CLASS, modules.get(1).getClassification());
	}

	@Test
	public void testLowerSecondClassModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.LOWER_SECOND_CLASS, modules.get(2).getClassification());
	}

	@Test
	public void testThirdClassModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.THIRD_CLASS, modules.get(3).getClassification());
	}

	@Test
	public void testCompensatableFailWhenNonCoreModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.COMPENSATABLE_FAIL, modules.get(4).getClassification());
	}

	@Test
	public void testFailWhenCoreModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.FAIL, modules.get(5).getClassification());
	}

	@Test
	public void testFailModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.FAIL, modules.get(6).getClassification());
	}

	@Test
	public void testFirstClassWhenNoExamModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.FIRST_CLASS, modules.get(7).getClassification());
	}

	@Test
	public void testFirstClassWhenNoCourseworkModuleSet()
	{
		markCalculatorService.calculateAllModuleMarks(modules);

		assertEquals(Module.Classification.FIRST_CLASS, modules.get(8).getClassification());
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
