import java.util.Scanner;

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


public class RotateLL {

    public ListNode rotateList(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;

        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = head;

        k = k % length;
        k = length - k;

        while(k-- > 0) {
            current = current.next;
        }

        head = current.next;
        current.next = null;

        return head;
    }

    public static void printList(ListNode head) {
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

        System.out.print("Enter elements: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();

        if (n == 0) return;

        System.out.print("Enter the elements: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();
        RotateLL obj = new RotateLL();
        ListNode rotatedHead = obj.rotateList(head, k);
        System.out.print("Rotated List: ");
        printList(rotatedHead);
        sc.close();
    }

}
