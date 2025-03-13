import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XORSubArrayCount {
    public int CountXorArray(int[] nums, int k){
        int count=0;
        int n= nums.length;
        int xr=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(xr,1);
        for(int i=0;i<n;i++){
            xr=xr^nums[i];
            int x = xr^k;
            if(map.containsKey(x)){
                count+=map.get(x);
            }

            if(map.containsKey(xr)){
                map.put(xr,map.get(xr)+1);
            }
            else{
                map.put(xr,1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers (space-seperated):");
        String[] n = sc.nextLine().split(" ");

        int[] nums = new int[n.length];
        for(int i=0;i<n.length;i++){
            nums[i]=Integer.parseInt(n[i]);
        }

        System.out.println("Enter value of k:");
        int k = sc.nextInt();

        XORSubArrayCount cs = new XORSubArrayCount();
        int result = cs.CountXorArray(nums, k);

        System.out.println("The count of subarray with XOR as K is "+result);
        sc.close();
    }
}
