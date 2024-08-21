import java.util.*;

class Node {
    String data;
    Node left, right;

    Node(String item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    int i;
    Node constructTree(String expression) {
        Stack<Node> stack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        char[] tokens = expression.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char token : tokens) {
            if (token == '(') {
                continue;
            } else if (token == '+' || token == '-' || token == '*' || token == '/') {
                charStack.push(token);
            } else if (token == ')') {
                Node right = stack.pop();
                Node left = stack.pop();
                char operator = charStack.pop();

                Node newNode = new Node(Character.toString(operator));
                newNode.left = left;
                newNode.right = right;
                stack.push(newNode);
            } else {
                // For leaf nodes (operands or variables)
                while (Character.isLetterOrDigit(token)) {
                    sb.append(token);
                    token = tokens[++i];
                }
                i--;

                stack.push(new Node(sb.toString()));
                sb.setLength(0);
            }
        }
        return stack.pop();
    }

    int evaluateExpressionTree(Node node, Map<String, Integer> variables) {
        if (node == null) return 0;

        if (Character.isDigit(node.data.charAt(0))) {
            return Integer.parseInt(node.data);
        } else if (Character.isLetter(node.data.charAt(0))) {
            return variables.getOrDefault(node.data, 0);
        } else {
            int leftVal = evaluateExpressionTree(node.left, variables);
            int rightVal = evaluateExpressionTree(node.right, variables);

            switch (node.data.charAt(0)) {
                case '+':
                    return leftVal + rightVal;
                case '-':
                    return leftVal - rightVal;
                case '*':
                    return leftVal * rightVal;
                case '/':
                    if (rightVal == 0) {
                        throw new ArithmeticException("Division by zero!");
                    }
                    return leftVal / rightVal;
                default:
                    return 0;
            }
        }
    }

    void printRootValue(Node root, Map<String, Integer> variables) {
        int result = evaluateExpressionTree(root, variables);
        System.out.println("Value of the root: " + result);
    }
}

public class ExpressionTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a fully parenthesized arithmetic expression:");
        String expression = scanner.nextLine();

        BinaryTree tree = new BinaryTree();
        Node root = tree.constructTree(expression);

        Map<String, Integer> variables = new HashMap<>();

        tree.printRootValue(root, variables);

        // Interactive variable update
        while (true) {
            System.out.println("Enter variable name to update (or 'exit' to quit):");
            String variableName = scanner.nextLine();

            if (variableName.equals("exit")) {
                break;
            }

            System.out.println("Enter the new value for " + variableName + ":");
            int value = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            variables.put(variableName, value);
            tree.printRootValue(root, variables);
        }

        scanner.close();
    }
}
