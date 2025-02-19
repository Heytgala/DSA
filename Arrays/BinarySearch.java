import java.util.Scanner;

public class BinarySearch {

    public boolean binarySearch(int[] nums, int target){
        int n= nums.length;
        int low= 0;
        int high = n-1;
        
        while(low<=high){
            int mid=low+high/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter numbers (space-separated):");
        String[] input = scanner.nextLine().split(" ");
        
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.println("Enter target number to search:");
        int target = scanner.nextInt();
        
        BinarySearch bs = new BinarySearch();
        boolean result = bs.binarySearch(nums, target);
        
        System.out.println("Target found: " + result);

        scanner.close();
    }
}