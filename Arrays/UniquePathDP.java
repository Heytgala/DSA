import java.util.Scanner;

public class UniquePathDP {

    public int recursion(int i,int j){
        if(i==0 || j==0) return 1;
        if (i<0 || j<0) return 0;
        int up=recursion(i-1, j);
        int left=recursion(i, j-1);
        return up+left;
    }
    public int UniquePaths(int m,int n){
        int prev[] = new int[n];
        for(int i=0;i<m;i++){
            int temp[]=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    temp[j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0){
                    up=prev[j];
                }
                if(j>0){
                    left=temp[j-1];
                }
                temp[j]=up+left;
            }
            prev=temp;
        }
        return prev[n-1];
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of rows (m):");
        int m = scanner.nextInt();
        System.out.println("Enter number of columns (n): ");
        int n = scanner.nextInt();

        UniquePathDP dp = new UniquePathDP();
        int result = dp.UniquePaths(m,n);

        System.out.println("The unique ways are: "+result);
        scanner.close();
    }
}
