import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = (long)(nums[i]+nums[j]+nums[k]+nums[l]);
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;
                        k++;
                        l--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }

            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter numbers (space-separated):");
        String[] input = scanner.nextLine().split(" ");
        
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.println("Enter target sum:");
        int target = scanner.nextInt();

        FourSum fs= new FourSum();
        List<List<Integer>> result = fs.fourSum(nums, target);
        System.out.println("Quadruplets that sum to " + target + ":");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
        scanner.close();
    }
}
