import java.util.Scanner;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int maxproduct=Integer.MIN_VALUE;
        int prefix=1, suffix=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix=prefix*nums[i];
            suffix=suffix*nums[n-i-1];
            maxproduct=Math.max(maxproduct,Math.max((prefix), suffix));
        }
        
        return maxproduct;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (space-separated):");
        String[] input = scanner.nextLine().split(" ");

        int[] nums= new int[input.length];
        for(int i=0;i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }

        MaxProduct mp = new MaxProduct();
        int result = mp.maxProduct(nums);

        System.out.println("The result: " +result);
        scanner.close();
    }
}
