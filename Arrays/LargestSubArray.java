import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestSubArray {


    public int largestsubarraysum(int[] nums,long k){
        int n= nums.length;
        Map<Long,Integer> set = new HashMap<>();
        long sum = 0;
        int maxlength=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum == k){
                maxlength = i+1;
            }
            if (set.containsKey(sum - k)) {
                maxlength = Math.max(maxlength, i - set.get(sum - k));
            }
            if(!set.containsKey(sum)){
                set.put(sum, i);
            }

        }
        return maxlength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers (space-seperated):");
        String[] num = sc.nextLine().split(" ");

        int[] n = new int[num.length];
        for(int i=0;i<num.length;i++){
            n[i]=Integer.parseInt(num[i]);
        }

        System.out.println("Enter value of k:");
        long k = sc.nextLong();


        LargestSubArray lsm = new LargestSubArray();
        int result = lsm.largestsubarraysum(n,k);

        System.out.println("The largest subarray sum is "+result);

        sc.close();
    }
}
