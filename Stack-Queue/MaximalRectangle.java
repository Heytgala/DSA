import java.util.Scanner;
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    
    public int largestRectangleArea(int[] heights){
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

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightsmall[i] - leftsmall[i] + 1));
        }
        return maxA;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();
        char[][] matrix = new char[rows][cols];
        System.out.println("Enter the matrix (0s and 1s):");
        for (int i = 0; i < rows; i++) {
            String row = scanner.next();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }
        MaximalRectangle solution = new MaximalRectangle();
        int result = solution.maximalRectangle(matrix);
        System.out.println("Maximal rectangle area: " + result);
        scanner.close();    
    }

}
