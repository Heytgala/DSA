import java.util.Scanner;

public class SubArrayOddSum {
    public int numOfSubarrays(int[] arr) {
        int oddcount=0;
        int evencount = 1;
        int sum=0;
        int result=0;
        int mod = 1_000_000_007;

        for(int n: arr){
            sum+=n;
            if(sum%2==0){
                result+=oddcount;
                evencount++;
            }
            else{
                result+=evencount;
                oddcount++;
            }
            result%=mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter numbers (space-seperated)");
        String[] input = scanner.nextLine().split(" ");

        int[] nums= new int[input.length];
        for(int i=0; i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }

        SubArrayOddSum sb = new SubArrayOddSum();
        int result=sb.numOfSubarrays(nums);

        System.out.println("Output: " + result);

        scanner.close();
    }
}
