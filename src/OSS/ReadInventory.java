package OSS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//Reads the inventory file and fills the inventory arraylist with the information
class ReadInventory{
    public ArrayList<Item> Read() throws FileNotFoundException {
        String[] itemTemp;
        ArrayList<Item> TempArrl = new ArrayList<>();
        int count = 0;
        double dTemp;
        int iTemp;
        String idTemp;
        String expDate;

        Boolean tempIsBulk;

        File Inventory = new File("Inventory.txt");
        Scanner scInventory = new Scanner(Inventory);
        while(scInventory.hasNextLine()){
            itemTemp = scInventory.nextLine().split(",");
            idTemp = itemTemp[0];
            dTemp = Double.parseDouble(itemTemp[1]);
            iTemp = Integer.parseInt(itemTemp[3]);
            expDate = itemTemp[4];
            tempIsBulk = (isBulkStringtoBool(itemTemp[5]));
            TempArrl.add(count,new Item(idTemp,dTemp,itemTemp[2],iTemp, expDate, tempIsBulk));
            count++;
        }
        scInventory.close();
        return (TempArrl);
    }

    // Helper Function
    boolean isBulkStringtoBool(String isBulk){
        switch(isBulk.toLowerCase().trim()){
            case "true":
            case "1":
            case "YES":
                return true;

            case "false":
            case "0":
            case "NO":
                return false;

            default:
                System.out.println("Cannot decipher " + isBulk + " as Boolean value.");
                return false;
        }
    }
}