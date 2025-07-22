import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low ;
        int j = high;
        while(i<j){
            while(arr[i]<= pivot &&i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array (space-separated):");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
