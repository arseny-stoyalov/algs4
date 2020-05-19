package com.company;

public final class ServiceClass {

    public static String postfixToInfix(String input) {

        MyStack<String> stack = new MyStack<>();
        input = input.trim().replaceAll("\\s{2,}", " ");
        for (char element : input.toCharArray()) {
            String first;
            String second;
            switch (element) {
                case ' ': break;
                case '*':
                case '/':
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first + " " + element + " " + second);
                    break;
                case '+':
                case '-':
                case '–':
                    second = stack.pop();
                    first = stack.pop();
                    stack.push("(" + first + " " + element + " " + second + ")");
                    break;
                default:
                    stack.push(String.valueOf(element));
            }

        }

        return stack.peek();
    }

}
