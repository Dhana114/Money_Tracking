package services;

import models.ExpenseModel;
import models.IncomeModel;

public class TransactionService {

    public String addIncome(String title, double amount, int month){

        IncomeModel incomeModel = new IncomeModel();
        incomeModel.setTitle(title);
        incomeModel.setAmount(amount);
        incomeModel.setMonth(month);



        return incomeModel.toString();

    }

    public ExpenseModel addExpense(String category, String des, int month, int amount){

        ExpenseModel expenseModel = new ExpenseModel();
        expenseModel.setCategory(category);
        expenseModel.setAmount(amount);
        expenseModel.setMonth(month);
        expenseModel.setDescription(des);

        return expenseModel;

    }










}
