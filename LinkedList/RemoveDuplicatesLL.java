import java.util.List;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next, prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class RemoveDuplicatesLL {

    public ListNode removeDuplicates(ListNode head){
        ListNode temp = head;
        ListNode nextnode = null;
        while(temp!=null && temp.next!=null){
            nextnode = temp.next;
            while(nextnode!=null && nextnode.val==temp.val){
                nextnode = nextnode.next;
            }
            temp.next = nextnode;
            if(nextnode != null){
                nextnode.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode createList(int[] values) {
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

    public static void printlist(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
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
        RemoveDuplicatesLL remover = new RemoveDuplicatesLL();
        head = remover.removeDuplicates(head);
        System.out.print("List after removing duplicates: ");
        printlist(head);
        sc.close();
    }
}
