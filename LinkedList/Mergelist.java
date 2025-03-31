import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){this.val=val; this.next=next;}
}

public class Mergelist {
    public ListNode mergetwolist(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val>list2.val){
            ListNode temp=list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode res = list1;

        while(list1!=null && list2!=null){
            ListNode tmp = null;
            while(list1!=null && list1.val<=list2.val){
                tmp=list1;
                list1=list1.next;
            }
            tmp.next = list2;
            ListNode temp = list1;
            list1=list2;
            list2=temp;
        }

        return res;
    }

    public static void printlist(ListNode head){
        while(head!=null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Create first sorted linked list:");
        ListNode list1 = createList(sc);

        System.out.println("Create second sorted linked list:");
        ListNode list2 = createList(sc);
        
        Mergelist obj = new Mergelist();
        ListNode mergedHead = obj.mergetwolist(list1, list2);

        System.out.print("The merged resulted linked list is: ");
        printlist(mergedHead);
        
        sc.close();
    }
}
