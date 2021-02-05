package uk.co.jimbodev.universitymarkcalculator.input;

import org.junit.jupiter.api.Test;
import uk.co.jimbodev.universitymarkcalculator.model.Module;

import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssessmentMarkInputTest
{
	@Test
	public void testAllValidInputMarksGetSavedCorrectlyInTheModuleList() throws Exception
	{
		withTextFromSystemIn("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
			.execute(() -> {
				List<Module> modules = new AssessmentMarkInput().inputMarksForAllFirstYearAssessments();

				Module csc2021 = modules.get(0);
				assertEquals(1, csc2021.getExams().get(0).getMark());
				assertEquals(2, csc2021.getCoursework().get(0).getMark());
				assertEquals(3, csc2021.getCoursework().get(1).getMark());
				assertEquals(4, csc2021.getCoursework().get(2).getMark());

				Module csc2022 = modules.get(1);
				assertEquals(5, csc2022.getExams().get(0).getMark());
				assertEquals(6, csc2022.getCoursework().get(0).getMark());
				assertEquals(7, csc2022.getCoursework().get(1).getMark());

				Module csc2023 = modules.get(2);
				assertEquals(8, csc2023.getCoursework().get(0).getMark());
				assertEquals(9, csc2023.getCoursework().get(1).getMark());

				Module csc2024 = modules.get(3);
				assertEquals(10, csc2024.getExams().get(0).getMark());
				assertEquals(11, csc2024.getCoursework().get(0).getMark());

				Module csc2025 = modules.get(4);
				assertEquals(12, csc2025.getExams().get(0).getMark());
				assertEquals(13, csc2025.getCoursework().get(0).getMark());

				Module csc2026 = modules.get(5);
				assertEquals(14, csc2026.getExams().get(0).getMark());
				assertEquals(15, csc2026.getCoursework().get(0).getMark());
			});
	}

	@Test
	public void testCorrectPrintStatementsForFirstYearModulesWhenAllInputsAreValid() throws Exception
	{
		withTextFromSystemIn("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
			.execute(() -> {
				String text = tapSystemOut(() -> {
					 new AssessmentMarkInput().inputMarksForAllFirstYearAssessments();
				});
				assertEquals("\n"
						+ "Enter Exam Mark for Programming I - Examination > Enter Coursework Mark for Programming I - Project 1 > Enter Coursework Mark for Programming I - Project 2 > Enter Coursework Mark for Programming I - Problem Solving Exercises > \n"
						+ "Enter Exam Mark for Programming II - Examination > Enter Coursework Mark for Programming II - Project > Enter Coursework Mark for Programming II - Problem Solving Exercises > Enter Coursework Mark for The Software Engineering Professional - Written Exercise 1 > Enter Coursework Mark for The Software Engineering Professional - Written Exercise 2 > \n"
						+ "Enter Exam Mark for Computer Architecture - Examination > Enter Coursework Mark for Computer Architecture - Lab Report 1 > \n"
						+ "Enter Exam Mark for Mathematics for Computer Science - Examination > Enter Coursework Mark for Mathematics for Computer Science - Problem Solving Exercises > \n"
						+ "Enter Exam Mark for Website Design and Construction - Examination > Enter Coursework Mark for Website Design and Construction - Lab Report 1 > ", text);
				System.out.println(text);
			});
	}

	@Test
	public void testCorrectPrintStatementsForFirstYearModulesWhenFirstInputIsTooLow() throws Exception
	{
		withTextFromSystemIn("-1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
			.execute(() -> {
				String text = tapSystemOutNormalized(() -> {
					new AssessmentMarkInput().inputMarksForAllFirstYearAssessments();
				});

				assertEquals("\n" + "Enter Exam Mark for Programming I - Examination > \n"
						+ "Please enter a valid Mark between 0 and 100 > \n"
						+ "Enter Coursework Mark for Programming I - Project 1 > Enter Coursework Mark for Programming I - Project 2 > Enter Coursework Mark for Programming I - Problem Solving Exercises > \n"
						+ "Enter Exam Mark for Programming II - Examination > Enter Coursework Mark for Programming II - Project > Enter Coursework Mark for Programming II - Problem Solving Exercises > Enter Coursework Mark for The Software Engineering Professional - Written Exercise 1 > Enter Coursework Mark for The Software Engineering Professional - Written Exercise 2 > \n"
						+ "Enter Exam Mark for Computer Architecture - Examination > Enter Coursework Mark for Computer Architecture - Lab Report 1 > \n"
						+ "Enter Exam Mark for Mathematics for Computer Science - Examination > Enter Coursework Mark for Mathematics for Computer Science - Problem Solving Exercises > \n"
						+ "Enter Exam Mark for Website Design and Construction - Examination > Enter Coursework Mark for Website Design and Construction - Lab Report 1 > ", text);

			});
	}

	@Test
	public void testCorrectPrintStatementsForFirstYearModulesWhenFirstInputIsTooHigh() throws Exception
	{
		withTextFromSystemIn("101", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
			.execute(() -> {
				String text = tapSystemOutNormalized(() -> {
					new AssessmentMarkInput().inputMarksForAllFirstYearAssessments();
				});

				assertEquals("\n" + "Enter Exam Mark for Programming I - Examination > \n"
						+ "Please enter a valid Mark between 0 and 100 > \n"
						+ "Enter Coursework Mark for Programming I - Project 1 > Enter Coursework Mark for Programming I - Project 2 > Enter Coursework Mark for Programming I - Problem Solving Exercises > \n"
						+ "Enter Exam Mark for Programming II - Examination > Enter Coursework Mark for Programming II - Project > Enter Coursework Mark for Programming II - Problem Solving Exercises > Enter Coursework Mark for The Software Engineering Professional - Written Exercise 1 > Enter Coursework Mark for The Software Engineering Professional - Written Exercise 2 > \n"
						+ "Enter Exam Mark for Computer Architecture - Examination > Enter Coursework Mark for Computer Architecture - Lab Report 1 > \n"
						+ "Enter Exam Mark for Mathematics for Computer Science - Examination > Enter Coursework Mark for Mathematics for Computer Science - Problem Solving Exercises > \n"
						+ "Enter Exam Mark for Website Design and Construction - Examination > Enter Coursework Mark for Website Design and Construction - Lab Report 1 > ", text);
			});
	}


}
