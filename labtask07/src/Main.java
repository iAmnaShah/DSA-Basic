public class Main {
    class DuplicateParenthesisChecker {
        public static boolean hasDuplicateParentheses(String expression) {
           //parenthesis Counter
            int openParenthesesCount = 0;
            //Iterating through each character
            for (char c : expression.toCharArray()) {
                // If the character is an opening parenthesis
                if (c == '(') {
                    openParenthesesCount++;
                }
                // If the character is a closing parenthesis
                else if (c == ')') {
                    if (openParenthesesCount == 0) {
                        return true;
                    }
                    openParenthesesCount--;
                }
            }
            return openParenthesesCount != 0;
        }

        public static void main(String[] args) {
            String expression1 = "((x+y))+z";
            if (hasDuplicateParentheses(expression1)) {
                System.out.println("The expression contains duplicate parentheses.");
            } else {
                System.out.println("The expression does not contain duplicate parentheses.");
            }
        }
    }


}