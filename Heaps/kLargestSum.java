import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargestSum {
    public int klargesum(int[] arr, int k,int n) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(minheap.size()<k){
                    minheap.add(sum);
                }
                else{
                    if(sum>minheap.peek()){
                        minheap.poll();
                        minheap.add(sum);
                    }
                }
            }
        }
        return minheap.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        kLargestSum kLargestSum = new kLargestSum();
        int result = kLargestSum.klargesum(arr, k,n);
        System.out.println("The " + k + " largest sum is: " + result);
        sc.close();
    }
}
