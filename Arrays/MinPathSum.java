import java.util.Arrays;
import java.util.Scanner;

public class MinPathSum {
    public int minpath(int i, int j, int[][] grid, int[][]dp){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return  (int)1e9;
        }
        if(dp[i][j]!=-1){ 
            return dp[i][j];
        }
        int up = grid[i][j] + minpath(i-1,j,grid,dp);
        int left = grid[i][j] + minpath(i,j-1,grid,dp);
        return dp[i][j]= Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minpath(n-1,m-1,grid,dp);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int m = scanner.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter grid values:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        MinPathSum mps = new MinPathSum();
        int minsum=mps.minPathSum(grid);
        System.out.println("The minimum path sum cost is " +minsum);
        scanner.close();
    }
}
