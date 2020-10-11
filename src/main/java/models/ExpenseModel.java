package models;

public class ExpenseModel {


    private String category;
    private String description;
    private double amount;
    private int month;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "[category = "
                + category
                + ",description = "
                + description
                + ",amount = "
                + amount
                + ",month = "
                + month + "]";
    }
}
