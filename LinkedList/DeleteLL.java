import java.util.Scanner;

class ListNode {
    int val;
    ListNode next, prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
public class DeleteLL {

    public ListNode deleteNode(ListNode head,int key){
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(temp!=null){
            if(temp.val==key){
                if(temp==head){
                    head=head.next;
                }
                nextNode = temp.next;
                prevNode = temp.prev;
                if(nextNode!=null){
                    nextNode.prev = prevNode;
                }
                if(prevNode!=null){
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    } 

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " <=> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode createList(int[] values){
        if(values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i=1;i<values.length;i++){
            ListNode nextNode = new ListNode(values[i]);
            current.next = nextNode;
            nextNode.prev = current;
            current = nextNode;
        }
        return head;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();

        int[] values = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        ListNode head = createList(values);
        System.out.print("Enter the key to delete: ");
        int key = sc.nextInt();

        System.out.print("Original list: ");
        printList(head);

        DeleteLL obj = new DeleteLL();
        head = obj.deleteNode(head, key);

        System.out.print("Updated list: ");
        printList(head);
        sc.close();
    }
}
