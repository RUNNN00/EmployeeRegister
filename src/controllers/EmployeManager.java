package controllers;

import java.util.ArrayList;
import java.util.List;
import entities.Department;
import entities.Employe;
import entities.enums.WorkerLevel;

public class EmployeManager
{
	List<Employe> employes = new ArrayList<Employe>();
	private int codeIDs = 0;

	
	public void registerNewEmploye(String name, Department dep, WorkerLevel lvl, double bSalary)
	{
		codeIDs++;
		Employe e = new Employe(codeIDs, name, dep, lvl, bSalary);

		if (employes.add(e))
			System.out.println("\nEmploye registered with SUCESSFULL\n");
		else
			System.out.println("\nRegister employe FAILED\n");
	}

	
	public void showEmployes(boolean descr)
	{
		if (employes.size() <= 0)
			System.out.println("Não há nenhum funcionário registrado!");
		else
			for (Employe e : employes)
			{
				if (descr)
					System.out.println(e.toString() + "\n");
				else
					System.out.println(e.getName());
			}
	}
}
