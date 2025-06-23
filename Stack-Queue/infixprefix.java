import java.util.Stack;

public class infixprefix {
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
    
    public String infixtoPrefix(String expression){
        
        // Reverse the infix expression
        StringBuilder reversedExpression = new StringBuilder();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                reversedExpression.append(')');
            } else if (ch == ')') {
                reversedExpression.append('(');
            } else {
                reversedExpression.append(ch);
            }
        }
        String prefix = new String("");
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < reversedExpression.length(); i++) {
            char ch = reversedExpression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                prefix += ch;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    prefix += stack.pop();
                }
                stack.pop(); 
            } 
            else {
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                    prefix += stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            prefix += stack.pop();
        }
        prefix = new StringBuilder(prefix).reverse().toString();
        return prefix;
    }
    
    public static void main(String[] args) {
        //String expression = "a+b*(c^d-e)^(f+g*h)-i";
        String expression = "(p+q)*(m-n)";
        System.out.println("Infix Expression: " + expression);
        infixprefix converter = new infixprefix();
        String prefix = converter.infixtoPrefix(expression);
        System.out.println("Prefix Expression: " + prefix);
    }
}
