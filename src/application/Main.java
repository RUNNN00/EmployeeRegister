package application;

import java.util.Locale;
import java.util.Scanner;
import controllers.EmployeManager;
import entities.Department;
import entities.enums.WorkerLevel;

public class Main
{
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		EmployeManager employeeManager = new EmployeManager();
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
					System.out.printf("\nEMPLOYES REGISTERED\n");
					System.out.printf("======================================\n");
					employeeManager.showEmployes(false);
					System.out.printf("======================================\n");
					break;
				case 2:
					System.out.printf("\nEMPLOYES REGISTERED\n");
					System.out.printf("======================================\n");
					employeeManager.showEmployes(true);
					System.out.printf("======================================\n");
					break;
				case 3:
					System.out.println("\nREGISTERING NEW EMPLOYE");
					System.out.printf("Enter name department: ");
					scanner.nextLine();
					String department = scanner.nextLine();
					System.out.printf("Name: ");
					String name = scanner.nextLine();
					System.out.printf("Level:\n");
					System.out.println("3 > SENIOR");
					System.out.println("2 > MID_LEVEL");
					System.out.println("1 > JUNIOR");
					int lvl = scanner.nextInt();
					String level = "";
					switch (lvl)
						{
						case 1:
							level = "JUNIOR";
							break;
						case 2:
							level = "MID_LEVEL";
							break;
						case 3:
							level = "SENIOR";
							break;
						default:
							level = "JUNIOR";
							break;
						}
					System.out.printf("Base Salary: ");
					double baseSal = scanner.nextDouble();
					employeeManager.registerNewEmploye(name, new Department(department), WorkerLevel.valueOf(level),
							baseSal);
					break;
				case 4:
					// TODO incrementar salário
					break;
				case 5:
					// TODO Deletar um employee
					break;
				case 0:
					System.out.println("Good bye!");
					break;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					break;
				}
		}
		scanner.close();
	}
}
