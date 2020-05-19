package com.company;

public class Main {

    public static void main(String[] args) {

        //Read postfix form from file
        String input = IOHandler.getInput();
        //Parse it to infix form
        String res = ServiceClass.postfixToInfix(input);
        //Write it to file
        IOHandler.setOutput(res);

        System.out.println("Successfully finished :-)");
    }

}
