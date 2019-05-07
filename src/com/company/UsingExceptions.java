package com.company;

import java.util.Scanner;

public class UsingExceptions {
    static int index = 0;
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        exceptionFun();
        //division
        try {
            division();
        }catch (Exception e) {
            System.out.println("Do we catch this exception again .....");
            System.out.println(""+e.getMessage());
        }

    }

    static void exceptionFun() throws IndexOutOfBoundsException {
        System.out.print("Enter the word: ");
        String temp = new String(keyboard.nextLine());
        System.out.println("The number of characters in this word: " + temp.length());
        System.out.print("Enter the index: ");
        index = keyboard.nextInt();

        try {
            if (index > temp.length()) {
                System.out.println("Testing exception");
                throw new IndexOutOfBoundsException(((Integer) index).toString());
            } else {
                System.out.println("The char at index " + index + " is " + temp.charAt(index));
                System.out.println("The substring is " + temp.substring(0, index));
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("This index is out of bounds\n");
        } finally {

            System.out.println("Testing exceptions.......");
        }

    }
    public static void division()throws IllegalAccessException {

        int a, b, result;

        keyboard.nextLine();
        System.out.println("Input two integers");

        a = keyboard.nextInt();
        b = keyboard.nextInt();
        try {
            if(b == 0) {
                throw new IllegalAccessException("In division method");
            }else {
                result = a / b;
                System.out.println("Result = " + result);
            }
        }catch (IllegalAccessException e) {
            System.out.println("Illegal access exception "+e.getMessage());
        }catch (Exception e) {
            System.out.println("Any other exceptions !!!");
        }

    }
}
