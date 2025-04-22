import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class FlatteningLL {

    // Merge two sorted linked lists
    public ListNode mergetwolist(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append remaining elements
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;
    }

    // Flatten list of k sorted lists
    public ListNode flattenll(List<ListNode> listHeads) {
        if (listHeads.isEmpty()) return null;

        ListNode merged = listHeads.get(0);
        for (int i = 1; i < listHeads.size(); i++) {
            merged = mergetwolist(merged, listHeads.get(i));
        }
        return merged;
    }

    public static void printlist(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode createList(Scanner sc) {
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();
        if (n == 0) return null;

        System.out.print("Enter elements in sorted order: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlatteningLL flatteningLL = new FlatteningLL();

        System.out.print("Enter number of Linked lists: ");
        int k = sc.nextInt();

        List<ListNode> listHeads = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            System.out.println("List " + (i + 1) + ":");
            ListNode head = createList(sc);
            listHeads.add(head);
        }

        ListNode result = flatteningLL.flattenll(listHeads);
        System.out.println("Flattened & Sorted Linked List:");
        printlist(result);

        sc.close();
    }
}
