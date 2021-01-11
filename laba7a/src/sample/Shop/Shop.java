package sample.Shop;
import java.time.LocalDate;
import java.util.Date;

public class Shop {
    private int id, cost, amount;
    private String name;
    private LocalDate date;

    public Shop(int id, int cost, int amount, String name, LocalDate date) {
        this.id = id;
        this.cost = cost;
        this.amount = amount;
        this.name = name;
        this.date = date;
    }

    public Shop() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
}
