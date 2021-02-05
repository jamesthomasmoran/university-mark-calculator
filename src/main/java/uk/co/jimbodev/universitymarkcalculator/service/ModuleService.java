package uk.co.jimbodev.universitymarkcalculator.service;

import uk.co.jimbodev.universitymarkcalculator.constant.ModuleConstants;
import uk.co.jimbodev.universitymarkcalculator.model.Module;

import java.util.ArrayList;
import java.util.List;

public class ModuleService
{

	public List<Module> getFirstYearModules()
	{
		List<Module> modules = new ArrayList<>();

		modules.add(new Module(ModuleConstants.CSC1021_MODULE_CODE, ModuleConstants.CSC1021_MODULE_TITLE, ModuleConstants.CSC1021_MODULE_IS_CORE,
				ModuleConstants.CSC1021_EXAMS, ModuleConstants.CSC1021_COURSEWORK));

		modules.add(new Module(ModuleConstants.CSC1022_MODULE_CODE, ModuleConstants.CSC1022_MODULE_TITLE, ModuleConstants.CSC1022_MODULE_IS_CORE,
				ModuleConstants.CSC1022_EXAMS, ModuleConstants.CSC1022_COURSEWORK));

		modules.add(new Module(ModuleConstants.CSC1023_MODULE_CODE, ModuleConstants.CSC1023_MODULE_TITLE, ModuleConstants.CSC1023_MODULE_IS_CORE,
				ModuleConstants.CSC1023_EXAMS, ModuleConstants.CSC1023_COURSEWORK));

		modules.add(new Module(ModuleConstants.CSC1024_MODULE_CODE, ModuleConstants.CSC1024_MODULE_TITLE, ModuleConstants.CSC1024_MODULE_IS_CORE,
				ModuleConstants.CSC1024_EXAMS, ModuleConstants.CSC1024_COURSEWORK));

		modules.add(new Module(ModuleConstants.CSC1025_MODULE_CODE, ModuleConstants.CSC1025_MODULE_TITLE, ModuleConstants.CSC1025_MODULE_IS_CORE,
				ModuleConstants.CSC1025_EXAMS, ModuleConstants.CSC1025_COURSEWORK));

		modules.add(new Module(ModuleConstants.CSC1026_MODULE_CODE, ModuleConstants.CSC1026_MODULE_TITLE, ModuleConstants.CSC1026_MODULE_IS_CORE,
				ModuleConstants.CSC1026_EXAMS, ModuleConstants.CSC1026_COURSEWORK));

		return modules;
	}

}
