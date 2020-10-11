import models.ExpenseModel;
import models.IncomeModel;
import services.TransactionService;

import java.io.IOException;
import java.util.Scanner;

public class MoneyTrackApp {


    public static void main(String[] args) throws IOException {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter  Expense/income");
        System.out.println("Enter 1 for expense");
        System.out.println("Enter 2 for income");

        int inpType = myObj.nextInt();

        if(inpType == 1){
            System.out.println("Enter  Category");

            String category = myObj.next();  // Reading category input

            System.out.println("Enter  Descritpion");

            String des = myObj.next();  // Reading title input

            System.out.println("Enter amount ");

            double amount = myObj.nextDouble(); // Reading amount input


            System.out.println("Enter Month");

            int month = myObj.nextInt(); // Reading month input


            // Creating TransactionService object
            TransactionService transactionService = new TransactionService();
            // Adding input values to income model
            ExpenseModel expenseModel = transactionService.addExpense(category, des, month, amount);


            transactionService.saveJsonToFile(null, expenseModel, "expense");
        }
        if(inpType == 2) {
            System.out.println("Enter  title");

            String title = myObj.next();  // Reading title input

            System.out.println("Enter amount ");

            double amount = myObj.nextDouble(); // Reading amount input


            System.out.println("Enter Month");

            int month = myObj.nextInt(); // Reading month input


            // Creating TransactionService object
            TransactionService transactionService = new TransactionService();
            // Adding input values to income model
            IncomeModel incomeModel = transactionService.addIncome(title, amount, month);


            transactionService.saveJsonToFile(incomeModel, null, "income");
        }


}








    }



