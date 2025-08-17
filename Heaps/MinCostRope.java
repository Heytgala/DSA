import java.util.PriorityQueue;
import java.util.Scanner;

public class MinCostRope {
    public long minrope(long[] arr, int n){
        if (n <= 1) return 0;
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        long cost = 0;
        for(int i=0;i<n;i++){
            minheap.add(arr[i]);
        }

        while(minheap.size()>1){
            long a = minheap.poll();
            long b = minheap.poll();
            long sum = a + b;
            cost+=sum;
            minheap.add(sum);
        }
        return cost;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = sc.nextInt();
        long[] arr = new long[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        MinCostRope mcr = new MinCostRope();
        long result = mcr.minrope(arr, n);
        System.out.println("The min cost of ropes is "+ result);
        sc.close();
    }
}
