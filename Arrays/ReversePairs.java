import java.util.Scanner;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }

     public int mergesort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int count = mergesort(nums, low, mid);
        count += mergesort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    public int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0, j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (i = low, k = 0; i <= high; i++, k++) {
            nums[i] = temp[k];
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

        ReversePairs rp = new ReversePairs();
        int result = rp.reversePairs(nums);

        System.out.println("Total Reverse pairs: "+result);
        scanner.close();
    }
}
