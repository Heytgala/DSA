import java.util.Stack;

public class postfixprefix {
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
    public String postfixToPrefix(String expression){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String prefixExpression = ch + operand1 + operand2;
                stack.push(prefixExpression);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ab-de+f*/";
        System.out.println("Postfix Expression: " + postfix);
        postfixprefix converter = new postfixprefix();
        String prefix = converter.postfixToPrefix(postfix);
        System.out.println("Prefix Expression: " + prefix);
    }
}
