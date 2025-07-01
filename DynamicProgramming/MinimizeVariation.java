import java.util.*;

public class MinimizeVariation {
    public static long minimizeVariation(List<Integer> productSize) {
        int n = productSize.size();

        Collections.sort(productSize);


        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; 

                long currentVariation = (long) productSize.get(j) - productSize.get(i);

                long costIfILast = dp[i + 1][j] + currentVariation;

                long costIfJLast = dp[i][j - 1] + currentVariation;

                dp[i][j] = Math.min(costIfILast, costIfJLast);
            }
        }

        return dp[0][n - 1];
    }
    
    public static void main(String[] args) {
        List<Integer> productSize = Arrays.asList(6,1,4,2);
        System.out.println(minimizeVariation(productSize));   
    }
}
