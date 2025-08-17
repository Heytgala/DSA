import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoBinaryHeap {

    private void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public int[] mergebheap(int n, int m, int[] arr1, int[] arr2){
        int[] result = new int[n + m];
        int k = 0;

        for (int v : arr1) result[k++] = v;
        for (int v : arr2) result[k++] = v;

        int an = result.length;

        for (int i = an / 2 - 1; i >= 0; i--) {
            heapify(result, an, i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements for first array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter number of elements for second array:");
        int m = sc.nextInt();
        int[] ar = new int[m]; 
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < m; i++) {
            ar[i] = sc.nextInt();
        }

        MergeTwoBinaryHeap merger = new MergeTwoBinaryHeap();
        int[] merged = merger.mergebheap(n, m, arr, ar);

        System.out.println("Merged max-heap (array form):");
        System.out.println(Arrays.toString(merged));
        sc.close();
    }
}
