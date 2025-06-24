import java.util.Stack;

public class prefixpostfix {
    public int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    
    public String prefixToPostfix(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String postfixExpression = operand1 + operand2 + ch;
                stack.push(postfixExpression);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String expression = "*+pq-mn"; 
        System.out.println("Prefix Expression: " + expression);       
        prefixpostfix converter = new prefixpostfix();
        String postfix = converter.prefixToPostfix(expression);
        System.out.println("Postfix Expression: " + postfix);
    }
}
