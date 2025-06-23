import java.util.Stack;

public class prefixinfix {
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
    public String PrefixtoInfix(String expression){
        Stack<String> stack = new Stack<>();
        for(int i = expression.length() - 1; i >= 0; i--){
            char ch = expression.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infixExpression = "(" + operand1 + ch + operand2 + ")";
                stack.push(infixExpression);
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String expression = "*+pq-mn";
        // String expression = "(p+q)*(m-n)";
        System.out.println("Prefix Expression: " + expression);
        prefixinfix converter = new prefixinfix();
        String infix = converter.PrefixtoInfix(expression);
        System.out.println("Infix Expression: " + infix);
    }
}
