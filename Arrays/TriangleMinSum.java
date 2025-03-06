import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleMinSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int j=0;j<n;j++){
            dp[j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int d=triangle.get(i).get(j) + dp[j];
                int dg =  triangle.get(i).get(j) + dp[j+1];
                dp[j] = Math.min(d,dg);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows in the triangle:");
        int rows = sc.nextInt();

        List<List<Integer>> triangle = new ArrayList<>();

        System.out.println("Enter the triangle values row by row:");
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(sc.nextInt());
            }
            triangle.add(row);
        }

        TriangleMinSum tm = new TriangleMinSum();
        int result = tm.minimumTotal(triangle);
        System.out.println("The minimum total is "+result);
        sc.close();
    }
}