import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
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

    public List<Integer> mergeKarrays(List<List<Integer>> arr, int k){
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.isEmpty() || k <= 0) return result;

        int n = Math.min(k, arr.size());

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>(n, (a, b) -> Integer.compare(a.data, b.data));

        for (int i = 0; i < n; i++) {
            List<Integer> list = arr.get(i);
            if (list != null && !list.isEmpty()) {
                minHeap.offer(new Node(list.get(0), i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            result.add(cur.data);

            int nextJ = cur.j + 1;
            List<Integer> list = arr.get(cur.i);
            if (nextJ < list.size()) {
                minHeap.offer(new Node(list.get(nextJ), cur.i, nextJ));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(List.of(1, 5, 7));
        arrays.add(List.of(2, 3, 6));
        arrays.add(List.of(4, 8, 9));

        MergeKSortedArrays merger = new MergeKSortedArrays();
        List<Integer> mergedArray = merger.mergeKarrays(arrays, arrays.size());
        System.out.println("Merged Array: " + mergedArray);
    }
}
