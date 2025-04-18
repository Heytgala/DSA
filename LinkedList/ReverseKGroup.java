import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;
        ListNode nex=dummy;
        ListNode prev = dummy;
        int count=0;

        while(current.next!=null){
            current= current.next;
            count++;
        }

        while(count>=k){
            current = prev.next;
            nex = current.next;
            for(int i=1;i<k;i++){
                current.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = current.next;
            }
            prev = current;
            count-=k;
        }

        return dummy.next;
        
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

        ReverseKGroup obj = new ReverseKGroup();
        ListNode newHead = obj.reverseKGroup(head, k);
        printList(newHead);
        sc.close();
    }
}
