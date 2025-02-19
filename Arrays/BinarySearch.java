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

    public boolean binarySearchRecursive(int[] nums, int low, int high, int target) {
        if (low > high) {
            return false;
        }

        int mid = low + (high - low) / 2; 

        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return binarySearchRecursive(nums, mid + 1, high, target);
        } else {
            return binarySearchRecursive(nums, low, mid - 1, target);
        }
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
        
        System.out.println("Choose search method:");
        System.out.println("1. Iterative Binary Search");
        System.out.println("2. Recursive Binary Search");
        int choice = scanner.nextInt();

        BinarySearch bs = new BinarySearch();
        boolean result = false;

        if (choice == 1) {
            result = bs.binarySearch(nums, target);
        } else if (choice == 2) {
            result = bs.binarySearchRecursive(nums, 0, nums.length - 1, target);
        } else {
            System.out.println("Invalid choice! Please enter 1 or 2.");
        }
        
        System.out.println("Target found: " + result);

        scanner.close();
    }
}