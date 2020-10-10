import services.TransactionService;

import java.util.Scanner;

public class MoneyTrackApp {


    public static void main(String[] args)
    {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter income title");

        String title = myObj.nextLine();  // Read user input
        System.out.println("Enter amount ");

        String amount = myObj.nextLine();

        double d = Double.parseDouble(amount);

        System.out.println("Enter Month");

        String month = myObj.nextLine();



        TransactionService transactionService = new TransactionService();

        String incomeString = transactionService.addIncome(title, d, Integer.parseInt(month));


        System.out.println(incomeString);
    }







}
