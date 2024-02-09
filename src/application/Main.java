package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc =new Scanner(System.in);

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Entre com os dados do contrato:");
    System.out.print("Numero: ");
    int number = sc.nextInt();
    System.out.print("Data (dd/MM/yyyy):");
    LocalDate date = LocalDate.parse(sc.next(),format);
    System.out.print("Valor do contrato: ");
    double value = sc.nextDouble();

    Contract obj = new Contract(number,date,value);
    System.out.println("Entre com o numero de parcelas:");
    int n = sc.nextInt();
    ContractService contractService = new ContractService(new PaypalService());
    contractService.processContract(obj,n);

    System.out.println("Parcelas:");

    for(Installment installment : obj.getInstallments()){
      System.out.println(installment);
    }

    sc.close();
  }
}
