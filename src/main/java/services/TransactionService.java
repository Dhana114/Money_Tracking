package services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.ExpenseModel;
import models.IncomeModel;

import java.io.*;
import java.util.Scanner;

public class TransactionService {
    enum expense
    {
        category, description, amount, month ;
    }
    enum income
    {
        title, amount, month ;
    }
    enum categories{

        Food, Grocery, Shopping, Vacation, Household, BillsPayment;

    }

    public IncomeModel addIncome(String title, double amount, int month){

        IncomeModel incomeModel = new IncomeModel();
        incomeModel.setTitle(title);
        incomeModel.setAmount(amount);
        incomeModel.setMonth(month);
        return incomeModel;

    }

    public ExpenseModel addExpense(String category, String des, int month, double amount){

        ExpenseModel expenseModel = new ExpenseModel();
        expenseModel.setCategory(category);
        expenseModel.setAmount(amount);
        expenseModel.setMonth(month);
        expenseModel.setDescription(des);

        return expenseModel;

    }

    public void readJsonFile(String choice) {

        BufferedReader br = null;
        JsonParser parser = new JsonParser();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("/Users/dhanalakshmi/Downloads/income.json"));

            while ((sCurrentLine = br.readLine()) != null) {
               // System.out.println("Record:\t" + sCurrentLine);

                Object obj;
                obj = parser.parse(sCurrentLine);
                JsonObject jsonObject = (JsonObject) obj;

                JsonArray jsonChoice = (JsonArray) jsonObject.get(choice);

                if (choice.equals("income")) {
                    System.out.format("%s %20s %32s %16s\n", "id", "Title", "Amount", "Month");
                    for (int i = 0; i < jsonChoice.size(); i++) {
                        JsonObject loopJsonObj = jsonChoice.get(i).getAsJsonObject();
                        System.out.format("%d %20s %32s %16s\n", i + 1, loopJsonObj.get("title"), loopJsonObj.get("amount"), loopJsonObj.get("month"));


                    }
                }

                else {
                    System.out.format("%s %20s %45s %32s %16s\n", "id", "Category", "Description", "Amount", "Month");
                    for (int i = 0; i < jsonChoice.size(); i++) {
                        JsonObject loopJsonObj = jsonChoice.get(i).getAsJsonObject();
                        System.out.format("%d %20s %45s %32s %16s\n", i + 1, loopJsonObj.get("category"), loopJsonObj.get("description"),loopJsonObj.get("amount"), loopJsonObj.get("month"));


                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    

    public  void saveJsonToFile(IncomeModel incomeModel,ExpenseModel expenseModel, String inpType) throws FileNotFoundException {

        Gson incomeGson = new Gson();
        JsonObject modelTojson = new JsonObject();
        if (incomeModel != null){
            //Converting incomeModel to json Object
            modelTojson = (JsonObject) incomeGson.toJsonTree(incomeModel);


       // System.out.println("The income model is:" + incomeModel);
    }
    else

        {
            modelTojson=  (JsonObject) incomeGson.toJsonTree(expenseModel);
          //  System.out.println("the expense model is:" + expenseModel );
    }

        // Reading json file
        FileReader jsonFile = new FileReader("/Users/dhanalakshmi/Downloads/income.json");
        JsonParser parser = new JsonParser();



        JsonObject jsonFileObject = new JsonObject();

        try {
            // Retrieving  json file data as json object
            jsonFileObject = (jsonFile)!= null ? parser.parse(jsonFile).getAsJsonObject() : jsonFileObject;



           // System.out.println("json object is:" + jsonFileObject);


            // get income value from json object if not null

            JsonArray incomeJsonArray =jsonFileObject.get(inpType) != null ? jsonFileObject.get(inpType).getAsJsonArray(): new JsonArray();

           // System.out.println("the json array is as follows:"+incomeJsonArray);
            //adding income json object to json array
            incomeJsonArray.add(modelTojson);
            //appending user input income  to jsonFileObject
            jsonFileObject.add(inpType, incomeJsonArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
//writing new json file object to json file
        try{

//          File Writer creates a file in write mode at the given location

            FileWriter file = new FileWriter("/Users/dhanalakshmi/Downloads/income.json");

//          Here we convert the obj data to string and put/write it inside the json file

            file.write(jsonFileObject.toString());
            file.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

       // System.out.print(jsonFileObject);




    }




public void editJsonEntry(int id, String choice, String key, String value) throws IOException {

    // Reading json file
    FileReader jsonFile = new FileReader("/Users/dhanalakshmi/Downloads/income.json");
    JsonParser parser = new JsonParser();



    JsonObject jsonFileObject = new JsonObject();

    // Retrieving  json file data as json object
    jsonFileObject =  parser.parse(jsonFile).getAsJsonObject();
    // System.out.println("json object is:" + jsonFileObject);
    // get income value from json object if not null

    JsonArray choiceJson = (JsonArray) jsonFileObject.get(choice);
    double amount = 0.0;
    int month = 0;
    if (key.equals("amount")){
    amount  = Double.parseDouble(value);
    choiceJson.get(id - 1).getAsJsonObject().addProperty(key,amount);
    }
    else if(key.equals("month")){
    month = Integer.parseInt(value);
    choiceJson.get(id - 1).getAsJsonObject().addProperty(key,month);
    }
    else {
    choiceJson.get(id - 1).getAsJsonObject().addProperty(key, value);
    }

    try{

//          File Writer creates a file in write mode at the given location

        FileWriter file = new FileWriter("/Users/dhanalakshmi/Downloads/income.json");

//          Here we convert the obj data to string and put/write it inside the json file

        file.write(jsonFileObject.toString());
        file.flush();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }



}

    public void editDetails() throws IOException {

        TransactionService transactionService = new TransactionService();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
      //  int inpType = myObj.nextInt();
        System.out.println("Enter  Expense/income");
        System.out.println("Enter 1 for expense");
        System.out.println("Enter 2 for income");

        int choice = myObj.nextInt();

        if (choice == 1) {

            transactionService.readJsonFile("expense");
            System.out.println("Please enter id you want to edit");
            int id = myObj.nextInt();

            System.out.println("Enter 1 to edit category");
            System.out.println("Enter 2 to edit description");
            System.out.println("Enter 3 to edit amount");
            System.out.println("Enter 4 to edit month");

            int key = myObj.nextInt();

            if (key == 1){

                System.out.println("Change category from the below list");
                for (categories c : categories.values()) {
                    System.out.println(  c);
                }
            }

            System.out.println("Enter new value for selected" + TransactionService.expense.values()[key - 1]);

            String value = myObj.next();

            transactionService.editJsonEntry(id, "expense", TransactionService.expense.values()[key - 1].toString(), value);
            transactionService.readJsonFile("expense");
        }
        else if (choice == 2) {

            transactionService.readJsonFile("income");
            System.out.println("Please enter id you want to edit");
            int id = myObj.nextInt();

            System.out.println("Enter 1 to edit title");
            System.out.println("Enter 2 to edit amount");
            System.out.println("Enter 3 to edit month");

            int key = myObj.nextInt();

            System.out.println("Enter new value for selected" + TransactionService.income.values()[key - 1]);

            String value = myObj.next();

            transactionService.editJsonEntry(id, "income", TransactionService.income.values()[key - 1].toString(), value);
            transactionService.readJsonFile("income");


        }

        else{

            System.out.println("Enter a Valid input");
            transactionService.editDetails();

        }
    }

    public void addDetails() throws FileNotFoundException {
        TransactionService transactionService = new TransactionService();

        System.out.println("Enter  Expense/income");
        System.out.println("Enter 1 for expense");
        System.out.println("Enter 2 for income");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int inpType = myObj.nextInt();
        if (inpType == 1) {
            System.out.println("Choose Category from the list");

            int i = 1;
            while (i <= 5) {
                for (categories c : categories.values()) {
                    System.out.println(i + "." + c);
                    i++;
                }

            }


            String cat = myObj.next();  // Reading category input

           /*// for (int c = myObj.nextInt(); c < category.values().length; c++)
            categories c;
                for ( c : categories.values()) {
                    if(cat == (c.ordinal())+1){

                        System.out.println("The category you choose is" + c);

                    }
                }*/




            System.out.println("Enter  Descritpion");

            String des = myObj.next();  // Reading title input

            System.out.println("Enter amount ");

            double amount = myObj.nextDouble(); // Reading amount input


            System.out.println("Enter Month");

            int month = myObj.nextInt(); // Reading month input


            // Creating TransactionService object

            // Adding input values to income model
            ExpenseModel expenseModel = transactionService.addExpense(cat, des, month, amount);


            transactionService.saveJsonToFile(null, expenseModel, "expense");

        }
        else if (inpType == 2) {
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

        else{

            System.out.println("Enter a Valid input");
            transactionService.addDetails();

        }
    }

    public void displayDetails(){
        TransactionService transactionService = new TransactionService();



        System.out.println("Enter  Expense/income");
        System.out.println("Enter 1 for expense");
        System.out.println("Enter 2 for income");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int inpType = myObj.nextInt();
        transactionService.readJsonFile(inpType==1?"expense":"income");

    }

    public void removeEntry(String choice) throws FileNotFoundException {

        TransactionService transactionService = new TransactionService();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int inpType = myObj.nextInt();
        FileReader jsonFile = new FileReader("/Users/dhanalakshmi/Downloads/income.json");
        JsonParser parser = new JsonParser();



        JsonObject jsonFileObject = new JsonObject();

        // Retrieving  json file data as json object
        jsonFileObject =  parser.parse(jsonFile).getAsJsonObject();
        // System.out.println("json object is:" + jsonFileObject);
        // get income value from json object if not null

        JsonArray choiceJson = (JsonArray) jsonFileObject.get(choice);

        if (choice.equals("expense")) {

            transactionService.readJsonFile("expense");
            System.out.println("Please enter id you want to remove");
            int id = myObj.nextInt();
            if (id > 0 && id < choiceJson.size()-1){
                choiceJson.remove(id -1);
            }

            else {

                System.out.println("Enter a valid input");
                transactionService.removeEntry(choice);
            }

            System.out.println("Succesfully deleted the expense at id " + id);
        }

        else {

            transactionService.readJsonFile("income");
            System.out.println("Please enter id you want to remove");
            int id = myObj.nextInt();
            if (id > 0 && id < choiceJson.size()-1){
                choiceJson.remove(id - 1);
            }

            else {

                System.out.println("Enter a valid input");
                transactionService.removeEntry(choice);
            }

            System.out.println("Succesfully deleted the income at id " + id);
        }
        try{

//          File Writer creates a file in write mode at the given location

            FileWriter file = new FileWriter("/Users/dhanalakshmi/Downloads/income.json");

//          Here we convert the obj data to string and put/write it inside the json file

            file.write(jsonFileObject.toString());
            file.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }




    }

    public void delete() throws FileNotFoundException {

        TransactionService transactionService = new TransactionService();



        System.out.println("Enter  Expense/income");
        System.out.println("Enter 1 for expense");
        System.out.println("Enter 2 for income");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int inpType = myObj.nextInt();
        transactionService.removeEntry(inpType==1?"expense":"income");


    }

    }





