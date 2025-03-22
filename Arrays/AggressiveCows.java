import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public boolean canPlace(int[] nums, int mid, int k,int n){
        int countcow=1;
        int last = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]-last>=mid){
                countcow++;
                last=nums[i];
            }
            if (countcow >= k) return true;
        }
        return false;
    }

    public int aggressivecows(int[] nums, int k){
        Arrays.sort(nums);
        int n= nums.length;
        int high=nums[n-1]-nums[0];
        int min=1;
        while(min<=high){
            int mid = min + (high-min)/2;
            if(canPlace(nums,mid,k,n)==true){
                min = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers (space-seperated):");
        String[] n  = sc.nextLine().split(" ");
        int[] nums = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            nums[i] = Integer.parseInt(n[i]);
        }

        System.out.println("Enter number of aggressive cows:");
        int cows = sc.nextInt();

        AggressiveCows agc = new AggressiveCows();
        int result = agc.aggressivecows(nums, cows);

        System.out.println("The maximum possible minimum distance is: " + result);

        sc.close();
    }
}
