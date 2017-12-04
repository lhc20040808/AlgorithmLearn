import java.util.Stack;

/**
 * Created by qgg on 2017/12/4.
 */
public class StackSolution {

    /**
     * 150.Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if ("+".equals(c) || "-".equals(c) || "*".equals(c) || "/".equals(c)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(cal(num2, num1, c));
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }

    private int cal(int x, int y, String express) {
        if ("+".equals(express)) {
            return x + y;
        }

        if ("-".equals(express)) {
            return x - y;
        }

        if ("*".equals(express)) {
            return x * y;
        }

        if ("/".equals(express)) {
            return x / y;
        }

        return 0;
    }

    /**
     * 20.Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ')':
                    if (stack.isEmpty() || '(' != stack.pop()) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || '{' != stack.pop()) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || '[' != stack.pop()) {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackSolution solution = new StackSolution();
        System.out.print(solution.isValid("()"));
    }
}
