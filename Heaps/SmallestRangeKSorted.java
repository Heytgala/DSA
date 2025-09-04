import java.util.PriorityQueue;
import java.util.Scanner;

public class SmallestRangeKSorted {
    class Node{
        int data;
        int i;
        int j;
        Node(int data, int row, int col){
            this.data = data;
            i = row;
            j = col;
        }
    }

    public int kSorted(int[][] arr,int k, int n){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.data, b.data));
        for(int i=0;i<k;i++){
            int element = arr[i][0];
            min = Math.min(min, element);
            max = Math.max(max, element);
            minHeap.add(new Node(element, i, 0));

        }
        int start = min;
        int end = max;
        while(!minHeap.isEmpty()){
            Node cur = minHeap.poll();
            min = cur.data;
            if((end - start) > (max - min)){
                start = min;
                end = max;
            }
            int nextJ = cur.j + 1;
            if(nextJ < n){
                int nextVal = arr[cur.i][nextJ];
                max = Math.max(max, nextVal);
                minHeap.add(new Node(nextVal, cur.i, nextJ));
            } else {
                break;
            }
        }
        return end - start;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine().trim());
        int[][] arr = new int[k][];
        for(int i=0;i<k;i++){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                arr[i] = new int[0];
                continue;
            } 
            String[] parts = line.split("\\s+");
            int[] row = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                row[j] = Integer.parseInt(parts[j]);
            }
            arr[i] = row;
        }
        SmallestRangeKSorted sr = new SmallestRangeKSorted();
        int ans = sr.kSorted(arr, k, 0);
        System.out.println("Smallest Range is: " + ans);
        sc.close();
    }
}
