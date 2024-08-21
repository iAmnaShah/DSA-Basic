import java.util.Scanner;

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public char top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}

public class Main {
    private static Node head;

    public static String infixToPostfix(String input) {
        StringBuilder postfix = new StringBuilder();
        Stack stack = new Stack();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.top() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop the '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0; // Lower precedence for other characters
    }

    public static float postfixEvaluation(String postfix) {
        Stack stack = new Stack();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c);
            } else {
                float operand2 = Float.parseFloat(String.valueOf(stack.pop()));
                float operand1 = Float.parseFloat(String.valueOf(stack.pop()));
                float result = performOperation(operand1, operand2, c);
                stack.push(String.valueOf(result).charAt(0));
            }
        }

        return Float.parseFloat(String.valueOf(stack.pop()));
    }

    private static float performOperation(float operand1, float operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
        }
        return 0; // Invalid operator
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the infix expression: ");
        String infixExpression = scanner.nextLine();

        // Now you have the infix expression as a string.

        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        float result = postfixEvaluation(postfixExpression);
        System.out.println("Result: " + result);
    }
}