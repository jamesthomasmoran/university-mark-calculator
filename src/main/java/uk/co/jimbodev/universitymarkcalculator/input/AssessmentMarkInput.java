package uk.co.jimbodev.universitymarkcalculator.input;

import uk.co.jimbodev.universitymarkcalculator.model.Assessment;
import uk.co.jimbodev.universitymarkcalculator.model.Module;
import uk.co.jimbodev.universitymarkcalculator.service.ModuleService;

import java.util.List;
import java.util.Scanner;

public class AssessmentMarkInput
{
	private static final String EXAM_QUESTION_PREFIX = "\nEnter Exam Mark for ";
	private static final String CW_QUESTION_PREFIX = "Enter Coursework Mark for ";
	private static final String QUESTION_SUFFIX = " > ";
	private static final String ERROR_QUESTION = "\nPlease enter a valid Mark between 0 and 100 > ";

	public List<Module> inputMarksForAllFirstYearAssessments()
	{
		List<Module> modules = new ModuleService().getFirstYearModules();

		Scanner scanner = new Scanner(System.in);

		for(Module module : modules)
		{
			for(Assessment assessment : module.getExams())
			{
				addValidatedMarkToAssessment(EXAM_QUESTION_PREFIX, assessment, module, scanner);
			}
			for(Assessment assessment : module.getCoursework())
			{
				addValidatedMarkToAssessment(CW_QUESTION_PREFIX, assessment, module, scanner);
			}
		}
		return modules;
	}

	private void addValidatedMarkToAssessment(String questionPrefix, Assessment assessment, Module module, Scanner scanner)
	{
		Boolean validMark = false;
		System.out.print(questionPrefix + module.getName() + " - " + assessment.getName() + QUESTION_SUFFIX);
		while (!validMark)
		{

			Double mark = scanner.nextDouble();
			if(mark != null && mark >= 0.00 && mark <= 100.00)
			{
				assessment.setMark(mark);
				validMark = true;
			}
			else
			{
				System.out.println(ERROR_QUESTION);
				scanner.nextLine();
			}
		}
	}
}
