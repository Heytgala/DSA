import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int leftsmall[] = new int[n];
        int rightsmall[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }

            if (st.isEmpty()) leftsmall[i] = 0;
            else leftsmall[i] = st.peek() + 1;
            st.push(i);
        }

        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightsmall[i] = n - 1;
            else rightsmall[i] = st.peek() - 1;

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightsmall[i] - leftsmall[i] + 1));
        }
        return maxArea;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of heights: ");
        int n = scanner.nextInt();
        int[] heights = new int[n];
        System.out.print("Enter the heights: ");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        LargestRectangleArea solution = new LargestRectangleArea();
        int result = solution.largestRectangleArea(heights);
        System.out.println("Largest rectangle area: " + result);
        scanner.close();
    }
}
