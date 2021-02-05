package uk.co.jimbodev.universitymarkcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Assessment
{
	public enum Type
	{
		EXAM,
		COURSEWORK
	}
	private String name;
	private Type type;
	private Double weighting;
	private Double mark;

	public Assessment(String name, Type type, Double weighting)
	{
		this.name = name;
		this.type = type;
		this.weighting = weighting;
	}
}
