import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLinkedList {
    static class LinkedListNode {
        int data;
        LinkedListNode next;
        LinkedListNode(int data) { this.data = data; }
    }

    public static LinkedListNode mergeKLists(LinkedListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<LinkedListNode> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.data));

        for (LinkedListNode head : lists) {
            if (head != null) minHeap.offer(head);
        }
        if (minHeap.isEmpty()) return null;

        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            LinkedListNode node = minHeap.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) minHeap.offer(node.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListNode[] listArray = new LinkedListNode[3];

        listArray[0] = new LinkedListNode(1);
        listArray[0].next = new LinkedListNode(4);
        listArray[0].next.next = new LinkedListNode(7);

        listArray[1] = new LinkedListNode(2);
        listArray[1].next = new LinkedListNode(5);
        listArray[1].next.next = new LinkedListNode(8);

        listArray[2] = new LinkedListNode(3);
        listArray[2].next = new LinkedListNode(6);
        listArray[2].next.next = new LinkedListNode(9);

        LinkedListNode mergedHead = MergeKLinkedList.mergeKLists(listArray);

        for (LinkedListNode cur = mergedHead; cur != null; cur = cur.next) {
            System.out.print(cur.data + (cur.next != null ? " " : "\n"));
        }
    }
}
