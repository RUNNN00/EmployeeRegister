package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employe;

public class EmployeManager
{
	List<Employe> employes = new ArrayList<Employe>();
	private int codeIDs = 0;

	
	public void registerNewEmploye(String name, double baseSalary)
	{		
		codeIDs++;
		Employe e = new Employe(codeIDs, name, baseSalary);
		
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
