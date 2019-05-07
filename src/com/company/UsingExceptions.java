package com.company;

import java.util.Scanner;
/*
    What is an exception?
    Definition: An exception is an event, which occurs during the execution of a program, that disrupts the normal flow
    of the program's instructions. Short answer: It's an error!

    So what am I supposed to do about it?
    You have two choices. Handle it or throw it up the call stack. We'll talk more about the call stack later. For now
    know that the call stack is a running list of the methods that have been called by your program. As each method
    finishes, control returns to the previous method.

    After your method throws an exception, Java looks for someone to handle it. If you've written code that can handle
    it, great! You're talking to the manager on duty. Otherwise the exception says to your method: "I want to talk to
    they guy who hired you!". Put your ear to your computer. It literally says that.

    So the method that called your method gets the error. Can that method handle it? No? The exception goes up the
    call stack. Somebody is going to handle this error. Or this program will crash. And heads will roll.

    Let's first look at some code that handles the exception on its own. This is easy - just surround the code that
    could cause an error with try..catch statements.

    Here we consider the possibility that the file doesn't exist or isn't available. Since that is a likely possibility
    then let's give the user a "nice" message instead of crashing abruptly when that event occurs. Notice that we can
    have one to as many catch clauses as we like. We simply list them in order of most specific exception to most
    general exception.
 */

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
