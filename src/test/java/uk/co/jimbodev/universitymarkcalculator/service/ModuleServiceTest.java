package uk.co.jimbodev.universitymarkcalculator.service;

import org.junit.jupiter.api.Test;
import uk.co.jimbodev.universitymarkcalculator.model.Assessment;
import uk.co.jimbodev.universitymarkcalculator.model.Module;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModuleServiceTest
{
	private ModuleService moduleService = new ModuleService();

	private List<Module> modules = moduleService.getFirstYearModules();

	@Test
	public void testCSC1021CorrectlyLoaded()
	{
		Module module = modules.get(0);
		List<Assessment> exams = module.getExams();
		List<Assessment> coursework = module.getCoursework();

		assertEquals("CSC1021", module.getCode());
		assertEquals("Programming I", module.getName());
		assertTrue(module.getCore());

		assertEquals("Examination", exams.get(0).getName());
		assertEquals(0.5, exams.get(0).getWeighting());

		assertEquals("Project 1", coursework.get(0).getName());
		assertEquals(0.2, coursework.get(0).getWeighting());
		assertEquals("Project 2", coursework.get(1).getName());
		assertEquals(0.2, coursework.get(1).getWeighting());
		assertEquals("Problem Solving Exercises", coursework.get(2).getName());
		assertEquals(0.1, coursework.get(2).getWeighting());
	}

	@Test
	public void testCSC1022CorrectlyLoaded()
	{
		Module module = modules.get(1);
		List<Assessment> exams = module.getExams();
		List<Assessment> coursework = module.getCoursework();

		assertEquals("CSC1022", module.getCode());
		assertEquals("Programming II", module.getName());
		assertTrue(module.getCore());

		assertEquals("Examination", exams.get(0).getName());
		assertEquals(0.6, exams.get(0).getWeighting());

		assertEquals("Project", coursework.get(0).getName());
		assertEquals(0.28, coursework.get(0).getWeighting());
		assertEquals("Problem Solving Exercises", coursework.get(1).getName());
		assertEquals(0.12, coursework.get(1).getWeighting());
	}

	@Test
	public void testCSC1023CorrectlyLoaded()
	{
		Module module = modules.get(2);
		List<Assessment> exams = module.getExams();
		List<Assessment> coursework = module.getCoursework();

		assertEquals("CSC1023", module.getCode());
		assertEquals("The Software Engineering Professional", module.getName());
		assertFalse(module.getCore());

		assertEquals(0, exams.size());

		assertEquals("Written Exercise 1", coursework.get(0).getName());
		assertEquals(0.5, coursework.get(0).getWeighting());
		assertEquals("Written Exercise 2", coursework.get(1).getName());
		assertEquals(0.5, coursework.get(1).getWeighting());
	}

	@Test
	public void testCSC1024CorrectlyLoaded()
	{
		Module module = modules.get(3);
		List<Assessment> exams = module.getExams();
		List<Assessment> coursework = module.getCoursework();

		assertEquals("CSC1024", module.getCode());
		assertEquals("Computer Architecture", module.getName());
		assertFalse(module.getCore());

		assertEquals("Examination", exams.get(0).getName());
		assertEquals(0.5, exams.get(0).getWeighting());

		assertEquals("Lab Report 1", coursework.get(0).getName());
		assertEquals(0.5, coursework.get(0).getWeighting());
	}

	@Test
	public void testCSC1025CorrectlyLoaded()
	{
		Module module = modules.get(4);
		List<Assessment> exams = module.getExams();
		List<Assessment> coursework = module.getCoursework();

		assertEquals("CSC1025", module.getCode());
		assertEquals("Mathematics for Computer Science", module.getName());
		assertFalse(module.getCore());

		assertEquals("Examination", exams.get(0).getName());
		assertEquals(0.8, exams.get(0).getWeighting());

		assertEquals("Problem Solving Exercises", coursework.get(0).getName());
		assertEquals(0.2, coursework.get(0).getWeighting());
	}

	@Test
	public void testCSC1026CorrectlyLoaded()
	{
		Module module = modules.get(5);
		List<Assessment> exams = module.getExams();
		List<Assessment> coursework = module.getCoursework();

		assertEquals("CSC1026", module.getCode());
		assertEquals("Website Design and Construction", module.getName());
		assertFalse(module.getCore());

		assertEquals("Examination", exams.get(0).getName());
		assertEquals(0.65, exams.get(0).getWeighting());

		assertEquals("Lab Report 1", coursework.get(0).getName());
		assertEquals(0.35, coursework.get(0).getWeighting());
	}
}
