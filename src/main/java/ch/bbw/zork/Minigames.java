package ch.bbw.zork;

import java.util.Scanner;

public class Minigames {
    private Scanner scanner = new Scanner(System.in);

    public boolean randomNumberGame(){
        System.out.println("Guess a number from 1 to 10");
        int userInput = scanner.nextInt();
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber == userInput){
            System.out.println("You guessed right!");
            return false;
        } else {
            System.out.println("nah, you're dead.");
            return true;
        }
    }

    public boolean monsterGame(){
        System.out.println("The Monster wants to kill you!!!" +
                "but you can fight against it");
        boolean trueFalse = false;
        System.out.println("write /kill to kill the Monster before it kills you");
        String userInputCommand = scanner.nextLine();
        long endTime = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < endTime) {
            if (userInputCommand.equals("/kill")) {
                System.out.println("Monster is dead");
            } else {
                System.out.println("The Monster killed you \n You are dead");
                trueFalse = true;
            }
            break;
        }
        return trueFalse;
    }

}
