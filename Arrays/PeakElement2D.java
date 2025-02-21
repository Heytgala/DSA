import java.util.Scanner;

public class PeakElement2D {

    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n= mat[0].length;
        int low=0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }
            int left = (mid-1 >= 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid+1 < n) ? mat[maxRow][mid + 1] : -1;

            if(mat[maxRow][mid]> left && mat[maxRow][mid]>right){
                return new int[] { maxRow, mid };
            }

            if(left>mat[maxRow][mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[] { -1, -1 };
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of rows (m): ");
        int m = scanner.nextInt();
        System.out.println("Enter number of columns (n): ");
        int n = scanner.nextInt();

        int[][] mat = new int[m][n];

        System.out.println("Enter matrix elements row by row:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        PeakElement2D pk= new PeakElement2D();
        int[] result = pk.findPeakGrid(mat);

        if (result[0] != -1 && result[1] != -1) {
            System.out.println("Peak element found at position: [" + result[0] + ", " + result[1] + "]");
            System.out.println("Peak element value: " + mat[result[0]][result[1]]);
        } else {
            System.out.println("No peak element found.");
        }
        
        scanner.close();
    }
}