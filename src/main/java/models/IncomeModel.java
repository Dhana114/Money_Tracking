package models;

public class IncomeModel {

    private String title;
    private double amount;
    private int month;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString()
    {
        return "[title = "
                + title
                + ",amount = "
                + amount
                + ",month = "
                + month + "]";
    }
}
