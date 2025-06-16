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

public class Add1LL {

    public int helper(ListNode head){
        if(head==null) return 1;
        int carry = helper(head.next);
        head.val += carry;
        if(head.val<10) return 0;
        head.val = 0;
        return 1;
    }

    public ListNode addOne(ListNode head) {
        int carry = helper(head);
        if(carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in the list:");
        int n = sc.nextInt();
        if(n==0) return;
        System.out.println("Enter the elements:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        Add1LL obj = new Add1LL();
        head = obj.addOne(head);
        System.out.println("List after adding 1:");
        while(head!=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        sc.close();
    }
}
