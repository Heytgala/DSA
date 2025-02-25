import java.util.Scanner;

public class MergeSort {

    public static void MergeSort(int[] nums){
        int n= nums.length;
        if(n<2){
            return;
        }
        int mid=n/2;
        int[] left=new int[mid];
        int[] right= new int[n-mid];
        for(int i=0;i<mid;i++){
            left[i]=nums[i];
        }
        for(int i=mid;i<n;i++){
            right[i-mid]=nums[i];
        }

        MergeSort(left);
        MergeSort(right);
        Merge(nums,left,right);

    }

    public static void Merge(int[] nums, int[] left, int[] right){
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while(i<left.length){
            nums[k++]=left[i++];
        }
        while(j<right.length){
            nums[k++]=right[j++];
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number (space separated):");
        String[] input = scanner.nextLine().split(" ");

        int[] nums= new int[input.length];
        for(int i=0;i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }

        MergeSort(nums);

        System.out.println("Sorted array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
