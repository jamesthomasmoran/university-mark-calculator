package uk.co.jimbodev.universitymarkcalculator.service;

import uk.co.jimbodev.universitymarkcalculator.model.Assessment;
import uk.co.jimbodev.universitymarkcalculator.model.Module;

import java.util.List;

public class MarkCalculatorService
{
	private static final Double THIRD_CLASS_MIN = 40.00;
	private static final Double COMPENSATABLE_FAIL_MIN = 35.00;
	private static final Double LOWER_SECOND_CLASS_MIN = 50.00;
	private static final Double UPPER_SECOND_CLASS_MIN = 60.00;
	private static final Double FIRST_CLASS_MIN = 70.00;


	public List<Module> calculateAllModuleMarks(List<Module> modules)
	{
		for(Module module : modules)
		{
			calculateTotalExamMark(module);
			calculateTotalCourseworkMark(module);
			module.setClassification(computeModuleClassification(module));
		}
		return modules;
	}


	private Module.Classification computeModuleClassification(Module module)
	{
		if((module.getCourseworkMark() < THIRD_CLASS_MIN && module.getCoursework().size() > 0) || (module.getExamMark() < THIRD_CLASS_MIN && module.getExams().size() > 0) || module.getTotalMark() < THIRD_CLASS_MIN)
		{
			if(!module.getCore() && module.getCourseworkMark() >= COMPENSATABLE_FAIL_MIN && module.getExamMark() >= COMPENSATABLE_FAIL_MIN)
			{
				return Module.Classification.COMPENSATABLE_FAIL;
			}
			else
			{
				return Module.Classification.FAIL;
			}
		}
		else if(module.getTotalMark() >= THIRD_CLASS_MIN && module.getTotalMark() < LOWER_SECOND_CLASS_MIN)
		{
			return Module.Classification.THIRD_CLASS;
		}
		else if(module.getTotalMark() >= LOWER_SECOND_CLASS_MIN && module.getTotalMark() < UPPER_SECOND_CLASS_MIN)
		{
			return Module.Classification.LOWER_SECOND_CLASS;
		}
		else if(module.getTotalMark() >= UPPER_SECOND_CLASS_MIN && module.getTotalMark() < FIRST_CLASS_MIN)
		{
			return Module.Classification.UPPER_SECOND_CLASS;
		}

		return Module.Classification.FIRST_CLASS;
	}

	private Module calculateTotalExamMark(Module module)
	{
		Double totalWeighting = 0.00;
		for(Assessment assessment : module.getExams())
		{
			totalWeighting += assessment.getWeighting();
			module.setExamWeightedMark(module.getExamWeightedMark() + (assessment.getMark() * assessment.getWeighting()));
		}

		module.setTotalMark(module.getTotalMark() + module.getExamWeightedMark());

		module.setExamMark(module.getExamWeightedMark() / totalWeighting);

		return module;
	}

	private Module calculateTotalCourseworkMark(Module module)
	{
		Double totalWeighting = 0.00;
		for(Assessment assessment : module.getCoursework())
		{
			totalWeighting += assessment.getWeighting();
			module.setCourseworkWeightedMark(module.getCourseworkWeightedMark() + (assessment.getMark() * assessment.getWeighting()));
		}

		module.setTotalMark(module.getTotalMark() + module.getCourseworkWeightedMark());

		module.setCourseworkMark(module.getCourseworkWeightedMark() / totalWeighting);

		return module;
	}
}
