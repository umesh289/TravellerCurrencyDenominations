package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    ArrayList<Integer> notes = new ArrayList<>();
    ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        Main driver = new Main();
        driver.enterDetails(scanner);
    }

    private void enterDetails(Scanner scanner){
        System.out.println("Enter the size of currency denominations");
        int numberOfNotes = scanner.nextInt();

        System.out.println("Enter the values of array");

        for (int i=1; i <= numberOfNotes; i++){
            int value  = scanner.nextInt();
            notes.add(value);
            numbers.add(0);
        }

        System.out.println("Enter the amount you want to pay");
        int amount  = scanner.nextInt();

        Collections.sort(notes, Comparator.reverseOrder());

        for (int j=0; j<notes.size(); j++){
            System.out.println(notes.get(j));
        }

        int count = 0;
        int number, value = 0;
        while (count < notes.size()){
            int noteValue = notes.get(count);
            number = amount/noteValue;

            if (number > 0) {
                numbers.add(count, number);
                amount = amount%noteValue;
            }

            if (amount == 0) {
                break;
            }
            count++;
        }

        System.out.println("Your payment approach in order to give min no of notes will be");
        for (int i=0; i<notes.size(); i++){
            int numberValue = numbers.get(i);

            if (numberValue == 0) {
                continue;
            } else {
                System.out.println(notes.get(i) + ":" + numberValue);
            }
        }
    }
}
