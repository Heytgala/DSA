import java.util.Scanner;
import java.util.Stack;

public class SumSubArrayRange {
    public long subArrayRanges(int[] nums) {
        return sumOfSubarrayMaximums(nums) - sumOfSubarrayMinimums(nums);
    }

    public long sumOfSubarrayMaximums(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            left[i]= (stack.isEmpty()) ? (i+1):(i-stack.peek());
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            right[i]= (stack.isEmpty()) ? (n-i):(stack.peek() - i);
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * left[i] * right[i];
        }
        return sum;
    }

    public long sumOfSubarrayMinimums(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            left[i]= (stack.isEmpty()) ? (i+1):(i-stack.peek());
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            right[i]= (stack.isEmpty()) ? (n-i):(stack.peek() - i);
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * left[i] * right[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];    
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        SumSubArrayRange solution = new SumSubArrayRange();
        long result = solution.subArrayRanges(nums);
        System.out.println("Sum of Subarray Ranges: " + result);
        scanner.close();
    }
}
