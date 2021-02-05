package uk.co.jimbodev.universitymarkcalculator.model;

import lombok.Data;

import java.util.List;

@Data
public class Module
{
	public enum Classification
	{
		FAIL,
		COMPENSATABLE_FAIL,
		THIRD_CLASS,
		LOWER_SECOND_CLASS,
		UPPER_SECOND_CLASS,
		FIRST_CLASS
	}
	private String code;
	private String name;
	private Boolean core;
	private Classification classification;
	private Double totalMark;
	private Double examMark;
	private Double examWeightedMark;
	private Double courseworkMark;
	private Double courseworkWeightedMark;
	private List<Assessment> exams;
	private List<Assessment> coursework;

	public Module(String code, String name, Boolean core, List<Assessment> exams, List<Assessment> coursework)
	{
		this.code = code;
		this.name = name;
		this.core = core;
		this.exams = exams;
		this.coursework = coursework;
		this.totalMark = 0.00;
		this.examMark = 0.00;
		this.courseworkMark = 0.00;
		this.examWeightedMark = 0.00;
		this.courseworkWeightedMark = 0.00;
	}
}
