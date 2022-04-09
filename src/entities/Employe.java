package entities;

public class Employe
{
	int id;
	String name;
	double salary;
	
	public Employe(int id, String name, double salary)
	{
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public int getId()
	{
		return id;
	}
	
	public String toString()
	{
		return "ID: " + id + 
				"\nName: " + name +
				"\nSalary: " + String.format("%.2f", salary);
	}
}
