import services.TransactionService;

import java.io.IOException;
import java.util.Scanner;

public class MoneyTrackApp {





    public static void main(String[] args) throws IOException {
        // Creating TransactionService
        //System.out.println(expense.values()[0]);
        TransactionService transactionService = new TransactionService();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Display/Add/edit");
        System.out.println("Enter 1 to Display Income/Expense");
        System.out.println("Enter 2 to Add Income/Expense");
        System.out.println("Enter 3 to Edit Income/Expense");
        System.out.println("Enter 4 to Remove Income/Expense");
        int inpType = myObj.nextInt();

        if(inpType == 1) {

            transactionService.displayDetails();
        }
        else if (inpType == 2) {

            transactionService.addDetails();
        }

        else if(inpType == 3){

            transactionService.editDetails();

        }
        else if(inpType == 4){

            transactionService.delete();

        }



        else{
            System.out.println("Enter a valid number");
        }
    }
}



