package kamal;

public class Expenses {

    int id, price, monthlyAmount, monthYearAmount;
    String name, monthlyBill, monthName;

    public Expenses() {
        super();
    }

    public Expenses(int id, int price, int monthlyAmount, int monthYearAmount, String name, String monthlyBill, String monthName) {
        super();
        this.id = id;
        this.price = price;
        this.monthlyAmount = monthlyAmount;
        this.monthYearAmount = monthYearAmount;
        this.name = name;
        this.monthlyBill = monthlyBill;
        this.monthName = monthName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(int monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public int getMonthYearAmount() {
        return monthYearAmount;
    }

    public void setMonthYearAmount(int monthYearAmount) {
        this.monthYearAmount = monthYearAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthlyBill() {
        return monthlyBill;
    }

    public void setMonthlyBill(String monthlyBill) {
        this.monthlyBill = monthlyBill;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

}
