package models;

import org.junit.Test;
import services.TransactionService;

import static org.junit.Assert.*;

public class IncomeModelTest {

    @Test
    public void getTitle() {
        TransactionService transactionService = new TransactionService();
        IncomeModel incomeModel = transactionService.addIncome("salary",5689,"jnauary");
        String expected = "salary";
        assertEquals(expected, incomeModel.getTitle());
    }

    @Test
    public void setTitle() {
        TransactionService transactionService = new TransactionService();
        IncomeModel incomeModel = transactionService.addIncome("salary",5689.00,"jnauary");
        incomeModel.setTitle("Scholarship");
        String expected = "Scholarship";
        assertEquals(expected, incomeModel.getTitle());
    }

    @Test
    public void getAmount() {

        TransactionService transactionService = new TransactionService();
        IncomeModel incomeModel = transactionService.addIncome("salary",5689.00,"jnauary");
        double expected = 5689.00;
        assertEquals(expected, incomeModel.getAmount(), 0);

    }

    @Test
    public void setAmount() {
        TransactionService transactionService = new TransactionService();
        IncomeModel incomeModel = transactionService.addIncome("salary",5689.00,"jnauary");
        incomeModel.setAmount(2456.00);
        double expected = 2456.00;
        assertEquals(expected, incomeModel.getAmount(), 0);

    }

    @Test
    public void getMonth() {
        TransactionService transactionService = new TransactionService();
        IncomeModel incomeModel = transactionService.addIncome("salary",5689,"jnauary");
        String expected = "jnauary";
        assertEquals(expected, incomeModel.getMonth());

    }

    @Test
    public void setMonth() {

        TransactionService transactionService = new TransactionService();
        IncomeModel incomeModel = transactionService.addIncome("salary",5689.00,"jnauary");
        incomeModel.setMonth("March");
        String expected = "March";
        assertEquals(expected, incomeModel.getMonth());

    }
}