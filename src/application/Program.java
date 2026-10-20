package application;

import model.entities.Contract;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        ContractService contractService = new ContractService(new PaypalService());
        Locale.setDefault(Locale.US);
        Scanner valor = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter of data contract");
        System.out.println("Number: ");
        Integer number = valor.nextInt();
        System.out.println("Date");
        LocalDate date = LocalDate.parse(string.nextLine(),fmt);
        System.out.println("Value of contract");
        Double valueTotal = valor.nextDouble();

        Contract contract = new Contract(number, date, valueTotal);

        System.out.println("Installments: ");
        Integer installments = valor.nextInt();

        contractService.processContract(contract, installments);

        System.out.println(contract);
    }
}
