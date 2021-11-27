package OSS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {
    ArrayList<Item> currItems = new ArrayList<>();

    public void getProductByID(String ID, Stock stock) {
        Item itemMatch = stock.matchByID(ID);
        if (!itemMatch.getItemID().equals("ERROR") ) {
            currItems.add(itemMatch);
        } else {
            System.out.println("Item " + ID + " not found. Item was not added to checkout list.");
        }
    }

}


