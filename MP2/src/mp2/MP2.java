/*
 * Create a program that will mimic the transfer of data from one register to
 * another. (Simulation)
 * 
 * Start with conversion of data (e.g. text) to ASCII. Mimic the activities
 * of the register inside the CPU
 */
package mp2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Paul Kiunisala
 */
public class MP2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string to be stored:");
        String input = s.next();
        ArrayList<Integer> mem = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            mem.add((int)input.charAt(i)); //convert characters of string to ASCII equivalent
        }
        //initialize MDR & MAR
        int MDR, MAR;
        int indexMax = input.length() - 1;
        System.out.println("1. Simulate Read");
        System.out.println("2. Simulate Write");
        System.out.println("Enter choice:");
        int choice = s.nextInt();
        if (choice == 1){
            System.out.println("Simulating Read"); 
            System.out.println("Enter address from 0 to " + indexMax);
            MAR = s.nextInt();
            System.out.println("Putting address " + MAR + " to MAR");
            System.out.println("Loading data at address " + MAR);
            System.out.println("Copying data to MDR");
            MDR = mem.get(MAR);
            System.out.println("Value of MDR: " + MDR);
        }
        else if (choice == 2){
            System.out.println("Simulating Write");
            System.out.println("Enter address from 0 to " + indexMax);
            MAR = s.nextInt();
            System.out.println("Enter a character for the new value:");
            MDR = (int)s.next().charAt(0);
            System.out.println("Value at address " + MAR + " before writing:" + mem.get(MAR));
            System.out.println("Storing new value to memory");
            mem.set(MAR, MDR);
            System.out.println("Value at address " + MAR + " after writing:" + mem.get(MAR));
        }
    }
}
