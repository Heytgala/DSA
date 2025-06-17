class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class LoopLengthLL {

    public int findLoopLength(ListNode slow,ListNode fast){
        int count = 1;
        fast=fast.next;
        while(slow!=fast){
            count++;
            fast = fast.next;
        }
        return count;
    }
    public int looplength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return findLoopLength(slow, fast);
            }
        }
        return 0;
    }
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next; 

        LoopLengthLL obj = new LoopLengthLL();
        int length = obj.looplength(head);
        System.out.println("Length of the loop: " + length);
    }
}
