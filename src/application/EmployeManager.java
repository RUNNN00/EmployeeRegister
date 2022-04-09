package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employe;

public class EmployeManager
{
	List<Employe> employes = new ArrayList<Employe>();
	private int codeIDs = 0;

	
	public void registerNewEmploye(Scanner scan)
	{
		System.out.println("\nREGISTERING NEW EMPLOYE");
		System.out.printf("Name: ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.printf("Salary: ");
		double sal = scan.nextDouble();
		
		codeIDs++;
		Employe e = new Employe(codeIDs, name, sal);
		
		if (employes.add(e))
			System.out.println("\nEmploye registered with SUCESSFULL\n");
		else
			System.out.println("\nRegister employe FAILED\n");
	}
	

	public void showEmployes(boolean descr)
	{
		System.out.printf("\nEMPLOYES REGISTEREDS\n");
		System.out.printf("======================================\n");
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
		System.out.printf("======================================\n\n");
	}
}
