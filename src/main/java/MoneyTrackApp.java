import models.ExpenseModel;
import models.IncomeModel;
import services.TransactionService;

import java.io.IOException;
import java.util.Scanner;

public class MoneyTrackApp {
    enum expense
    {
        category, description, amount, month ;
    }
    enum income
    {
        title, amount, month ;
    }


    public static void main(String[] args) throws IOException {
        // Creating TransactionService
        //System.out.println(expense.values()[0]);
        TransactionService transactionService = new TransactionService();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Display/Add/edit");
        int inpType = myObj.nextInt();
        if(inpType == 1){

            System.out.println("Enter  Expense/income");
            System.out.println("Enter 1 for expense");
            System.out.println("Enter 2 for income");

            inpType = myObj.nextInt();
            transactionService.readJsonFile(inpType==1?"expense":"income");

        }
        else if (inpType == 2) {


            System.out.println("Enter  Expense/income");
            System.out.println("Enter 1 for expense");
            System.out.println("Enter 2 for income");

            inpType = myObj.nextInt();

            if (inpType == 1) {
                System.out.println("Enter  Category");

                String category = myObj.next();  // Reading category input

                System.out.println("Enter  Descritpion");

                String des = myObj.next();  // Reading title input

                System.out.println("Enter amount ");

                double amount = myObj.nextDouble(); // Reading amount input


                System.out.println("Enter Month");

                int month = myObj.nextInt(); // Reading month input


                // Creating TransactionService object

                // Adding input values to income model
                ExpenseModel expenseModel = transactionService.addExpense(category, des, month, amount);


                transactionService.saveJsonToFile(null, expenseModel, "expense");
            }
            if (inpType == 2) {
                System.out.println("Enter  title");

                String title = myObj.next();  // Reading title input

                System.out.println("Enter amount ");

                double amount = myObj.nextDouble(); // Reading amount input


                System.out.println("Enter Month");

                int month = myObj.nextInt(); // Reading month input


                // Adding input values to income model
                IncomeModel incomeModel = transactionService.addIncome(title, amount, month);


                transactionService.saveJsonToFile(incomeModel, null, "income");


            }
        }
        else if(inpType == 3){

            System.out.println("Enter  Expense/income");
            System.out.println("Enter 1 for expense");
            System.out.println("Enter 2 for income");

            int choice = myObj.nextInt();

            if(choice == 1) {

                transactionService.readJsonFile("expense");
                System.out.println("Please enter id you want to edit");
                int id = myObj.nextInt();

                System.out.println("Enter 1 to edit category");
                System.out.println("Enter 2 to edit description");
                System.out.println("Enter 3 to edit amount");
                System.out.println("Enter 4 to edit month");

                int key = myObj.nextInt();

                System.out.println("Enter new value for selected" + expense.values()[key - 1]);

                String value = myObj.next();

                transactionService.editEntry(id, "expense", expense.values()[key - 1].toString(), value);
                transactionService.readJsonFile("expense");
            }
                else if(choice == 2) {

                    transactionService.readJsonFile("income");
                    System.out.println("Please enter id you want to edit");
                    int id = myObj.nextInt();

                    System.out.println("Enter 1 to edit title");
                    System.out.println("Enter 2 to edit amount");
                    System.out.println("Enter 3 to edit month");

                    int key = myObj.nextInt();

                    System.out.println("Enter new value for selected" + income.values()[key - 1]);

                    String value = myObj.next();

                    transactionService.editEntry(id, "income", income.values()[key - 1].toString(), value);
                    transactionService.readJsonFile("income");


                }












        }




}








    }



