import java.util.PriorityQueue;
import java.util.Scanner;

public class kSmallest {

    public int findKSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<k;i++){
            maxHeap.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]<maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        int result = maxHeap.peek();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        kSmallest kSmallest = new kSmallest();
        int result = kSmallest.findKSmallest(arr, k);
        System.out.println("The " + k + "th smallest element is: " + result);
        scanner.close();
    }
}
