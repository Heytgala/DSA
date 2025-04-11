import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Intersection {
    public ListNode findIntersection(ListNode list1, ListNode list2) {
        int len1 = getLength(list1);
        int len2 = getLength(list2);

        ListNode a = list1;
        ListNode b = list2;

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                b = b.next;
            }
        }

        while (a != null && b != null) {
            if (a == b) {
                return a;  
            }
            a = a.next;
            b = b.next;
        }
        return null; 
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static ListNode createList(Scanner sc) {
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();

        if (n == 0) return null;

        System.out.print("Enter the elements in sorted order: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create first sorted linked list:");
        ListNode list1 = createList(sc);
        System.out.println("Create second sorted linked list:");
        ListNode list2 = createList(sc);

        ListNode intersectionNode = list2.next.next; 
        ListNode temp = list1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = intersectionNode; 

        Intersection obj = new Intersection();
        ListNode result = obj.findIntersection(list1, list2);

        if (result != null) {
            System.out.println("Intersection found at node with value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }

        sc.close();
    }
}
