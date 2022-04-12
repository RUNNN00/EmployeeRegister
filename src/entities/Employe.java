package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Employe
{
	private int id;
	private String name;
	private double baseSalary;

	private Department department;
	private WorkerLevel level;
	private List<HourContract> contracts;

	public Employe(int id, String name, Department department, WorkerLevel level, double baseSalary)
	{
		this.id = id;
		this.name = name;
		this.department = department;
		this.level = level;
		this.baseSalary = baseSalary;
		contracts = new ArrayList<HourContract>();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setLevel(WorkerLevel level)
	{
		this.level = level;
	}

	public WorkerLevel getLevel()
	{
		return level;
	}

	public double getBaseSalary()
	{
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary)
	{
		this.baseSalary = baseSalary;
	}

	public int getId()
	{
		return id;
	}

	public String toString()
	{
		return "ID: " + id + "\nName: " + name + "\nBase Salary: " + String.format("%.2f", baseSalary);
	}

	// Funcções de execução da classe
	// ==========================================================================================
	public void addContract(HourContract contract)
	{
		contracts.add(contract);
	}

	public void removeContract(HourContract contract)
	{
		contracts.remove(contract);
	}

	public double income(int year, int month)
	{
		if (contracts.size() == 0)
			return baseSalary;
		
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts)
		{
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);

			if (c_year == year && c_month == month)
			{
				sum += c.totalValues();
			}
		}
		return sum;
	}
}
