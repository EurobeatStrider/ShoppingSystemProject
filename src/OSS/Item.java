package OSS;

import java.util.Date;

public class Item {

    private String itemID;
    private double price;
    private String name;
    private int numberOf = 0;
    private String expDate;

    private Boolean isBulk;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }

    public void addNumItems(int quantity){
        numberOf+=quantity;
    }
    public void subNumItems(int quantity){
        numberOf-=quantity;
    }

    public Item(String itemID, double price, String name, int numberOf, String expDate, Boolean isBulk) {
        this.itemID = itemID;
        this.expDate = expDate;
        this.price = price;
        this.name = name;
        this.numberOf = numberOf;
        this.isBulk = isBulk;
    }

    public String getItemID() {
        return itemID;
    }

    public String getExpDate() {
        return expDate;
    }

    public Boolean getIsBulk() { return isBulk; }

    @Override
    public String toString() {
        return (price + "," + name + "," + numberOf);
    }
}