package ch.bbw.zork;

import java.util.ArrayList;

public class Item {
    ArrayList inventory = new ArrayList<String>();



    public String receiveItem(String room) {
        System.out.println("room"+ room);
        switch (room){
            case "grab a true-fruits-smoothie":
                System.out.println("you received 1 extra life as you picked up a truefruits™ smoothie.");
                return "Truefruits";
            case "grab a m-budget energy-drink":
                System.out.println("you received 1 extra life as you picked up a m-budget energy.");
                return "Mbudget";
            default:
                break;
        }
         return null;
    }
}
