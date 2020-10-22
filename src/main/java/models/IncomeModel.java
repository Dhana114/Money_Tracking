package models;

public class IncomeModel {

    private String title;
    private double amount;
    private String month;

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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {

        this.month = month;

    }

    @Override
    public String toString()
    {
        System.out.println("title = "
                + title
                + ",amount = "
                + amount
                + ",month = "
                + month);
       return "[title = "
                + title
                + ",amount = "
                + amount
                + ",month = "
                + month + "]";


    }
}
