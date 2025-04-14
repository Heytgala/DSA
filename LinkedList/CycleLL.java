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


public class CycleLL{
    public static ListNode createList(Scanner sc){
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();
    
        if (n == 0) return null;
    
        System.out.print("Enter the elements: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;
    
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        System.out.print("Do you want to create a cycle in the list? (yes/no): ");
        String createCycle = sc.next();

        if (createCycle.equalsIgnoreCase("yes")) {
            System.out.print("Enter the position (1-based) to create the cycle: ");
            int cyclePosition = sc.nextInt();

            ListNode cycleNode = head;

            for (int i = 1; i < cyclePosition; i++) {
                cycleNode = cycleNode.next;
            }

            current.next = cycleNode;
        }
    
        return head;
    }    

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;           
            fast = fast.next.next;       
            
            if (slow == fast) {
                return true;  
            }
        }
        
        return false;  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create sorted linked list:");
        ListNode list1 = createList(sc);

        CycleLL cycleLL = new CycleLL();
        boolean hasCycle = cycleLL.hasCycle(list1);

        System.out.println("Does the linked list have a cycle? " + hasCycle);

        sc.close();

    }
}