package models;

import org.junit.Test;
import services.TransactionService;

import static org.junit.Assert.*;

public class ExpenseModelTest {

    @Test
    public void getCategory() {

        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        String expected = "Shopping";
        assertEquals(expected, expenseModel.getCategory());

    }

    @Test
    public void setCategory() {

        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        expenseModel.setCategory("Food");
        String expected = "Food";
        assertEquals(expected, expenseModel.getCategory());
    }

    @Test
    public void getDescription() {

        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        String expected = "Bought shoes shoes and clothes";
        assertEquals(expected, expenseModel.getDescription());

    }

    @Test
    public void setDescription() {

        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        expenseModel.setDescription("Brought some glasses and cosmetics");
        String expected = "Brought some glasses and cosmetics";
        assertEquals(expected, expenseModel.getDescription());
    }

    @Test
    public void getAmount() {
        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        double expected = 750.00;
        assertEquals(expected, expenseModel.getAmount(), 0);


    }

    @Test
    public void setAmount() {

        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        expenseModel.setAmount(2456.00);
        double expected = 2456.00;
        assertEquals(expected, expenseModel.getAmount(), 0);
    }

    @Test
    public void getMonth() {

        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        String expected = "March";
        assertEquals(expected, expenseModel.getMonth());
    }

    @Test
    public void setMonth() {
        TransactionService transactionService = new TransactionService();
        ExpenseModel expenseModel = transactionService.addExpense("Shopping", "Bought shoes shoes and clothes", "March", 750.00);
        expenseModel.setMonth("April");
        String expected = "April";
        assertEquals(expected, expenseModel.getMonth());
    }
}