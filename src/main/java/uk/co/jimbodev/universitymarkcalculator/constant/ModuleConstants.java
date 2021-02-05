package uk.co.jimbodev.universitymarkcalculator.constant;

import uk.co.jimbodev.universitymarkcalculator.model.Assessment;

import java.util.Arrays;
import java.util.List;

public class ModuleConstants
{
	public static final String CSC1021_MODULE_CODE = "CSC1021";
	public static final String CSC1021_MODULE_TITLE = "Programming I";
	public static final Boolean CSC1021_MODULE_IS_CORE = true;

	public static final String CSC1022_MODULE_CODE = "CSC1022";
	public static final String CSC1022_MODULE_TITLE = "Programming II";
	public static final Boolean CSC1022_MODULE_IS_CORE = true;

	public static final String CSC1023_MODULE_CODE = "CSC1023";
	public static final String CSC1023_MODULE_TITLE = "The Software Engineering Professional";
	public static final Boolean CSC1023_MODULE_IS_CORE = false;

	public static final String CSC1024_MODULE_CODE = "CSC1024";
	public static final String CSC1024_MODULE_TITLE = "Computer Architecture";
	public static final Boolean CSC1024_MODULE_IS_CORE = false;

	public static final String CSC1025_MODULE_CODE = "CSC1025";
	public static final String CSC1025_MODULE_TITLE = "Mathematics for Computer Science";
	public static final Boolean CSC1025_MODULE_IS_CORE = false;

	public static final String CSC1026_MODULE_CODE = "CSC1026";
	public static final String CSC1026_MODULE_TITLE = "Website Design and Construction";
	public static final Boolean CSC1026_MODULE_IS_CORE = false;

	private static final String CSC1021_EXAM_1_TITLE = "Examination";
	private static final Double CSC1021_EXAM_1_WEIGHTING = 0.5;

	private static final String CSC1021_CW_1_TITLE = "Project 1";
	private static final Double CSC1021_CW_1_WEIGHTING = 0.2;

	private static final String CSC1021_CW_2_TITLE = "Project 2";
	private static final Double CSC1021_CW_2_WEIGHTING = 0.2;

	private static final String CSC1021_CW_3_TITLE = "Problem Solving Exercises";
	private static final Double CSC1021_CW_3_WEIGHTING = 0.1;

	private static final String CSC1022_EXAM_1_TITLE = "Examination";
	private static final Double CSC1022_EXAM_1_WEIGHTING = 0.6;

	private static final String CSC1022_CW_1_TITLE = "Project";
	private static final Double CSC1022_CW_1_WEIGHTING = 0.28;

	private static final String CSC1022_CW_2_TITLE = "Problem Solving Exercises";
	private static final Double CSC1022_CW_2_WEIGHTING = 0.12;

	private static final String CSC1023_CW_1_TITLE = "Written Exercise 1";
	private static final Double CSC1023_CW_1_WEIGHTING = 0.5;

	private static final String CSC1023_CW_2_TITLE = "Written Exercise 2";
	private static final Double CSC1023_CW_2_WEIGHTING = 0.5;

	private static final String CSC1024_EXAM_1_TITLE = "Examination";
	private static final Double CSC1024_EXAM_1_WEIGHTING = 0.5;

	private static final String CSC1024_CW_1_TITLE = "Lab Report 1";
	private static final Double CSC1024_CW_1_WEIGHTING = 0.5;

	private static final String CSC1025_EXAM_1_TITLE = "Examination";
	private static final Double CSC1025_EXAM_1_WEIGHTING = 0.8;

	private static final String CSC1025_CW_1_TITLE = "Problem Solving Exercises";
	private static final Double CSC1025_CW_1_WEIGHTING = 0.2;

	private static final String CSC1026_EXAM_1_TITLE = "Examination";
	private static final Double CSC1026_EXAM_1_WEIGHTING = 0.65;

	private static final String CSC1026_CW_1_TITLE = "Lab Report 1";
	private static final Double CSC1026_CW_1_WEIGHTING = 0.35;

	public static final List<Assessment> CSC1021_EXAMS = Arrays.asList(
			new Assessment(CSC1021_EXAM_1_TITLE, Assessment.Type.EXAM, CSC1021_EXAM_1_WEIGHTING)
			);

	public static final List<Assessment> CSC1021_COURSEWORK = Arrays.asList(
			new Assessment(CSC1021_CW_1_TITLE, Assessment.Type.COURSEWORK, CSC1021_CW_1_WEIGHTING),
			new Assessment(CSC1021_CW_2_TITLE, Assessment.Type.COURSEWORK, CSC1021_CW_2_WEIGHTING),
			new Assessment(CSC1021_CW_3_TITLE, Assessment.Type.COURSEWORK, CSC1021_CW_3_WEIGHTING)
	);

	public static final List<Assessment> CSC1022_EXAMS = Arrays.asList(
			new Assessment(CSC1022_EXAM_1_TITLE, Assessment.Type.EXAM, CSC1022_EXAM_1_WEIGHTING)
	);

	public static final List<Assessment> CSC1022_COURSEWORK = Arrays.asList(
			new Assessment(CSC1022_CW_1_TITLE, Assessment.Type.COURSEWORK, CSC1022_CW_1_WEIGHTING),
			new Assessment(CSC1022_CW_2_TITLE, Assessment.Type.COURSEWORK, CSC1022_CW_2_WEIGHTING)
	);

	public static final List<Assessment> CSC1023_EXAMS = Arrays.asList(
	);

	public static final List<Assessment> CSC1023_COURSEWORK = Arrays.asList(
			new Assessment(CSC1023_CW_1_TITLE, Assessment.Type.COURSEWORK, CSC1023_CW_1_WEIGHTING),
			new Assessment(CSC1023_CW_2_TITLE, Assessment.Type.COURSEWORK, CSC1023_CW_2_WEIGHTING)
	);

	public static final List<Assessment> CSC1024_EXAMS = Arrays.asList(
			new Assessment(CSC1024_EXAM_1_TITLE, Assessment.Type.EXAM, CSC1024_EXAM_1_WEIGHTING)
	);

	public static final List<Assessment> CSC1024_COURSEWORK = Arrays.asList(
			new Assessment(CSC1024_CW_1_TITLE, Assessment.Type.COURSEWORK, CSC1024_CW_1_WEIGHTING)
	);

	public static final List<Assessment> CSC1025_EXAMS = Arrays.asList(
			new Assessment(CSC1025_EXAM_1_TITLE, Assessment.Type.EXAM, CSC1025_EXAM_1_WEIGHTING)
	);

	public static final List<Assessment> CSC1025_COURSEWORK = Arrays.asList(
			new Assessment(CSC1025_CW_1_TITLE, Assessment.Type.COURSEWORK, CSC1025_CW_1_WEIGHTING)
	);

	public static final List<Assessment> CSC1026_EXAMS = Arrays.asList(
			new Assessment(CSC1026_EXAM_1_TITLE, Assessment.Type.EXAM, CSC1026_EXAM_1_WEIGHTING)
	);

	public static final List<Assessment> CSC1026_COURSEWORK = Arrays.asList(
			new Assessment(CSC1026_CW_1_TITLE, Assessment.Type.COURSEWORK, CSC1026_CW_1_WEIGHTING)
	);
}
