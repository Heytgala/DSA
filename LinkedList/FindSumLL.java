import java.util.*;

class ListNode {
    int val;
    ListNode next, prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class FindSumLL {

    public List<int[]> findAllPairs(ListNode head, int sum) {
        List<int[]> result = new ArrayList<>();
        ListNode temp1 = head;

        while (temp1 != null) {
            ListNode temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.val + temp2.val == sum) {
                    result.add(new int[]{temp1.val, temp2.val});
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        return result;
    }

    public static ListNode createList(int[] values){
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            ListNode nextNode = new ListNode(values[i]);
            current.next = nextNode;
            nextNode.prev = current;
            current = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the list: ");
        int n = sc.nextInt();
        int[] values = new int[n];

        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        ListNode head = createList(values);

        System.out.print("Enter the value for sum: ");
        int key = sc.nextInt();

        FindSumLL obj = new FindSumLL();
        List<int[]> result = obj.findAllPairs(head, key);

        if (result.isEmpty()) {
            System.out.println("No such pair found.");
        } else {
            System.out.println("Pairs found:");
            for (int[] pair : result) {
                System.out.println(pair[0] + " + " + pair[1] + " = " + key);
            }
        }

        sc.close();
    }
}
