package application;

/*
 * IMPLEMENTAÇÕES
 * 	- Mostrar funcionarios
 *  - Mostrar funcionarios descrição
 *  	- Mostrar contratos de um funcionario
 *  	- Mostrar o income de um contrato de funcionario de um determinado mes
 *  - REgistrar funcionario
 *  - Incrementar aumento de salario
 *  - Adicionar contrato
 *  - Deletar funcionario
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import controllers.EmployeManager;
import entities.Department;
import entities.Employe;
import entities.enums.WorkerLevel;

public class Main
{
	public static void main(String[] args) throws ParseException
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
			System.out.println("> 5 -> Adicionar contratos");
			System.out.println("> 6 -> Delete employe");
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
					System.out.println("Informe o ID do funcionario para o income");
					System.out.println("Informe 0 para sair");
					System.out.printf("> ");
					option = scanner.nextInt();
					if (option != 0)
					{
						Employe e = employeeManager.getEmployee(option);
						if (e != null)
						{
							System.out.printf("\nInforme o ano: ");
							int year = scanner.nextInt();
							System.out.printf("informe o mes: ");
							int month = scanner.nextInt();
							System.out.printf("\n%s\n", e.getName().toUpperCase());
							System.out.println("Inocome for " + String.format("%02d", month) + "/" + year + ": "
									+ e.income(year, month) + "\n");
						} else
							System.out.println("\nInforme um ID válido!\n");
					}
					option = 10;
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
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					if (employeeManager.getQuantityEmployees() <= 0)
					{
						System.out.println("\nNão há nenhum funcionário para adicionar um contrato no momento\n");
						break;
					}

					System.out.println("\nADICIONANDO CONTRATO\n");
					System.out.printf("Informe o ID do funcionario: ");
					int id = scanner.nextInt();
					System.out.printf("Data (dd/MM/yyyy): ");
					Date date = sdf.parse(scanner.next());
					System.out.printf("Valor por hora: ");
					double valuePerHour = scanner.nextDouble();
					System.out.printf("Duração: ");
					int duration = scanner.nextInt();
					if (!employeeManager.addContract(id, date, valuePerHour, duration))
						System.out.println("\nERROR: o contrato nao foi adicionado com sucesso!\n");
					else
						System.out.println("\nContrato adicionado com sucesso\n");
					break;
				case 6:
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
