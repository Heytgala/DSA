import java.util.Scanner;
import java.util.Stack;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(Character ch: num.toCharArray()){
            while(!stack.isEmpty() && stack.peek()>ch && k>0){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String num = scanner.nextLine();
        System.out.print("Enter the number of digits to remove (k): ");
        int k = scanner.nextInt();
        RemoveKdigits solution = new RemoveKdigits();
        String result = solution.removeKdigits(num, k);
        System.out.println("Result after removing " + k + " digits: " + result);
        scanner.close();
    }
}
