import java.util.Stack;

public class infixpostfix {
    public int precedence(char ch){
        switch(ch){
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

    public String infixToPostfix(String expression){
        Stack<Character> stack = new Stack<Character>();
        String postfix = new String("");
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                postfix += ch;
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postfix += stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            postfix += stack.pop();
        }
        return postfix;
    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        // String expression = "(p+q)*(m-n)";
        System.out.println("Infix Expression: " + expression);
        infixpostfix converter = new infixpostfix();
        String postfix = converter.infixToPostfix(expression);
        System.out.println("Postfix Expression: " + postfix);
    }
}
