package services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.ExpenseModel;
import models.IncomeModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class TransactionService {

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

    public  void saveJsonToFile(IncomeModel incomeModel,ExpenseModel expenseModel, String inpType) throws FileNotFoundException {

        Gson incomeGson = new Gson();
        JsonObject modelTojson = new JsonObject();
        if (incomeModel != null){
            //Converting incomeModel to json Object
            modelTojson = (JsonObject) incomeGson.toJsonTree(incomeModel);

        System.out.println(incomeModel);
    }
    else

        {
            modelTojson=  (JsonObject) incomeGson.toJsonTree(expenseModel);
    }

        // Reading json file
        FileReader jsonFile = new FileReader("/Users/dhanalakshmi/Downloads/income.json");
        JsonParser parser = new JsonParser();

        JsonObject jsonFileObject = new JsonObject();
        try {
            // Retrieving  json file data as json object
            jsonFileObject = (jsonFile)!= null ? parser.parse(jsonFile).getAsJsonObject() : jsonFileObject;




            // get income value from json object if not null

            JsonArray incomeJsonArray =jsonFileObject.get(inpType) != null ? jsonFileObject.get(inpType).getAsJsonArray(): new JsonArray();

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

        System.out.print(jsonFileObject);




    }










}
