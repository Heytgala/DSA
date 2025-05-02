import java.util.Scanner;

public class TrapWater {
    public int trap(int[] height) {
        int total = 0;
        int n = height.length;
        int left = 0, right = n-1;
        int maxLeft = 0, maxRight = 0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(maxLeft>height[left]){
                    total += maxLeft - height[left];
                }
                else {
                    maxLeft = height[left];
                }
                left = left + 1;
            }
            else {
                if(maxRight>height[right]){
                    total += maxRight - height[right];
                }
                else{
                    maxRight = height[right];
                }
                right = right - 1;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter numbers (space-seperated)");
        String[] input = scanner.nextLine().split(" ");

        int[] nums= new int[input.length];
        for(int i=0; i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }

        TrapWater trapWater = new TrapWater();
        int result=trapWater.trap(nums);

        System.out.println("The unit of water trapped is " + result);

        scanner.close();
    }
}