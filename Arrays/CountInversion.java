import java.util.Scanner;

public class CountInversion {
    public int countinversion(int[] nums){
        return mergesort(nums,0,nums.length-1);
    }

    public int mergesort(int[]nums, int low, int high){
        int count=0;
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        count += mergesort(nums, low, mid);
        count += mergesort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }

    public int merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        int count=0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += (mid - i + 1);
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
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers (space-seperated)");
        String[] n = sc.nextLine().split(" ");

        int[]list = new int[n.length];
        for(int i=0;i<n.length;i++){
            list[i] = Integer.parseInt(n[i]);
        }
        CountInversion cv = new CountInversion();
        int result = cv.countinversion(list);
        System.out.println("The result of count inversion is " + result);
        sc.close();
    }
}
