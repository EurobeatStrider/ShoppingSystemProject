package OSS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {
    ArrayList<Item> currItems = new ArrayList<>();

    public Item getProductByID(int id) throws FileNotFoundException {
        String[] tempItem;
        int tempId;
        double tempPrice;
        String tempName;
        int tempAmount;
        String tempExpDate;
        Boolean tempIsBulk;

        Item newItem = null;

        File Inventory = new File("Inventory.txt");
        Scanner scInventory = new Scanner(Inventory);

        while(scInventory.hasNextLine()) {
            tempItem = scInventory.nextLine().split(",");
            tempId = Integer.parseInt(tempItem[0]);

            if (tempId == id) {
                tempPrice = Double.parseDouble(tempItem[1]);
                tempName = tempItem[2];
                tempAmount = Integer.parseInt(tempItem[3]);
                tempExpDate = tempItem[4];
                tempIsBulk = isBulkStringtoBool(tempItem[5]);

                newItem = new Item(Integer.toString(tempId), tempPrice, tempName, tempAmount, tempExpDate, tempIsBulk);
                break;
            }
        }
        if (newItem == null){
            System.out.println("Item " + id + " not found.");
        }
        return newItem;
    }

    // Helper Functions
    static boolean isBulkStringtoBool(String isBulk){
        switch(isBulk.toLowerCase().trim()){
            case "true":
            case "1":
                return true;

            case "false":
            case "0":
                return false;

            default:
                System.out.println("Cannot decipher " + isBulk + " as Boolean value.");
                return false;
        }
    }

}


