package services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.ExpenseModel;
import models.IncomeModel;

import java.io.*;

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




public void editEntry(int id, String choice, String key, String value) throws IOException {

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
    }



