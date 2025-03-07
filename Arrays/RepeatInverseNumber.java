import java.util.Scanner;

public class RepeatInverseNumber {
    public int[] XORfindMissingRepeatingNumbers(int[] nums){
        int n = nums.length;
        int xor=0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
            xor = xor ^ (i + 1);
        }

        int number = (xor & ~(xor-1));
        
        int zero =0;
        int one = 0;
        for(int i =0;i<n;i++){
            if((nums[i] & number) != 0){
                one = one ^ nums[i];
            }
            else {
                zero = zero ^ nums[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & number) != 0) {
                one = one ^ i;
            }
            else {
                zero = zero ^ i;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }

    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n= nums.length;
        long sum = (long) n*(n+1)/2;
        long sum2n = (long) n*(n+1)*(2*n+1)/6;

        long S=0;
        long Sn = 0;
        for(int i=0;i<n;i++){
            S+=nums[i];
            Sn+=(long)nums[i] * (long)nums[i];
        }

        long val = S - sum;
        long val2 = Sn - sum2n;

        val2 = val2/val;
        long x = (val + val2) / 2;
        long y = x - val;

        int[] ans = {(int)x, (int)y};
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers (space seperated)");
        String[] input = sc.nextLine().split(" ");
        int [] nums = new int[input.length];
        for(int i=0;i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }
        RepeatInverseNumber rn = new RepeatInverseNumber();
        int[] ans = rn.findMissingRepeatingNumbers(nums);
        System.out.println("The repeating and missing numbers are: {"
                           + ans[0] + ", " + ans[1] + "}");
        sc.close();

        ans = rn.XORfindMissingRepeatingNumbers(nums);
        System.out.println("The repeating and missing numbers with XOR method are: {"
                           + ans[0] + ", " + ans[1] + "}");
        sc.close();
    }
}
