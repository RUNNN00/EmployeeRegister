package application;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		EmployeManager employeManager = new EmployeManager();
		int option = 10;

		System.out.printf("======================================\n");
		System.out.println("               WELCOME                 ");
		System.out.printf("======================================\n\n");

		while (option != 0)
		{
			System.out.println("Informe a opção que deseja:");
			System.out.println("> 1 -> Show employes");
			System.out.println("> 2 -> Show employes description");
			System.out.println("> 3 -> Register new employe");
			System.out.println("> 4 -> Increasy salary");
			System.out.println("> 5 -> Delete employe");
			System.out.println("> 0 -> Exit");
			option = scanner.nextInt();

			switch (option)
				{
				case 1:
					employeManager.showEmployes(false);
					break;
				case 2:
					employeManager.showEmployes(true);
					break;
				case 3:
					employeManager.registerNewEmploye(scanner);
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					break;
				}
		}
		
		scanner.close();
	}
}
