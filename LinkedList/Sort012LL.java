import java.util.List;
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

public class Sort012LL{

    public ListNode sortList(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zero = zeroHead, one = oneHead, two = twoHead;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val==0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.val ==1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = oneHead.next!=null?oneHead.next:twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
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
        Sort012LL obj = new Sort012LL();
        head = obj.sortList(head);
        System.out.println("Sorted list:");
        while(head!=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        sc.close();
    }
}