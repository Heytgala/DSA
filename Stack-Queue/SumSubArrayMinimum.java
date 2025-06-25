import java.util.Scanner;
import java.util.Stack;

public class SumSubArrayMinimum {

    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) 1e9+7;
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] prevsmall = new int[n];
        int[] nextsmall = new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            prevsmall[i]= (stack.isEmpty()) ? (i+1):(i-stack.peek());
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            nextsmall[i] = (stack.isEmpty())? (n-i):(stack.peek()-i);
            stack.push(i);
        }

        long result = 0;
        for(int i=0;i<n;i++){
            long total = (long) nextsmall[i] * prevsmall[i] * arr[i];
            result = (result + total) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        SumSubArrayMinimum solution = new SumSubArrayMinimum();
        long result = solution.sumSubarrayMins(arr);
        System.out.println("Sum of Subarray Minimums: " + result);
        scanner.close();
    }
}
