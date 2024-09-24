package cc.atm;

import java.util.Scanner;

public class Keypad implements IKeypad {

    public int getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
