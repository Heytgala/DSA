import java.util.Stack;

public class postfixinfix {
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

    public String PostfixtoInfix(String expression){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String infixExpression = "(" + operand1 + ch + operand2 + ")";
                stack.push(infixExpression);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "ab-de+f*/";
        // String expression = "(p+q)*(m-n)";
        System.out.println("PostFix Expression: " + expression);
        postfixinfix converter = new postfixinfix();
        String infix = converter.PostfixtoInfix(expression);
        System.out.println("Infix Expression: " + infix);
    }
}