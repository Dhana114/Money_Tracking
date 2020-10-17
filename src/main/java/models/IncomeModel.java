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


        if (month >0 && month <=12 ) {
            this.month = month;
        }
        else{
            System.out.println("Enter a valid month");
        }

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
