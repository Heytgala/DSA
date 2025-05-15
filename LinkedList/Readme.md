# LINKED LIST
- Data Structure: Non-contiguous
- Memory Allocation: Typically allocated one by one to individual elements
- Insertion/Deletion: Efficient
- Access: Sequential

## 1. Merge 2 sorted list
### Algorithm:
        a. Initialize two pointers t1 & t2. Create dummy node & use temp pointer
        b. While t1 and t2 are not null:
            - Compare the values of t1 and t2, connect the node with smaller value to the temp pointer of the merged combined list.
            - Move the temp pointer and the respective t1 and t2 pointer to their next nodes.
        c. Attach the remaining nodes of the non-empty list directly to the temp pointer as they are already sorted.
        d. Return the next of the dummyNode as the head of the merge sorted linked list.

## 2. Intersection of 2 linked lists (Amazon, Microsoft)
### Approach:
        a. Find the length of both lists.
        b. Find the positive difference between these lengths.
        c. Move the dummy pointer of the larger list by the difference achieved. This makes our search length reduced to a smaller list length.
        d. Move both pointers, each pointing two lists, ahead simultaneously if both do not collide.

## 3. Reverse Linked List in groups of Size K
### Concept:
It simplifies reversing linked list nodes by breaking the list into segments of K nodes and reversing each segment individually. Starting from the head the algorithm traverses the list to identify segments of K nodes. Upon finding a segment, it reverses it, returning the modified list. If a segment has less than K nodes left (ie. remaining nodes at the end), they are left unaltered. 

### ALgorithm:
        a. Edge Case Handling:
           - If head == null or k == 1, return the head as it is because no reversal is needed.
        b. Dummy Node Initialization:
           - Initialize a dummy node with dummy.next = head to help with edge case handling.
        c. Count the Total Number of Nodes:
           - Traverse the list once and count how many nodes are there. This helps in determining if we have at least k nodes to reverse.
        d.Iterate and Reverse in Chunks of k:
           - While the number of nodes left (count) is greater than or equal to k:
              - For each group of k nodes:
                 - Set the current, nex, and prev pointers to handle the reversal.
                 - Reverse the nodes inside this group.
              - Move the prev pointer to the last node of the reversed group.
              - Update count by subtracting k (since we've reversed one group of k nodes).
        e. Return the Result:
           - Once all possible groups are reversed, return dummy.next, which points to the new head of the list.

## FLATTENING OF LINKED LIST (Amazon,Microsoft)
### Algorithm:
     a. Input Parsing
      - Read integer k – the number of sorted linked lists to merge.
      - For each list from 1 to k:
         - Read the number of elements n.
         - Read n integers in sorted order.
         - Create a singly linked list from those elements.
         - Store the head of each list in a list called listHeads.

     b. Merge Two Sorted Linked Lists (mergetwolist)
      - Initialize a dummy node to simplify list manipulation.
      - Use a tail pointer starting at the dummy node.
      - While both lists are non-null:
         - Compare the current values of list1 and list2.
         - Append the smaller value node to tail.next.
         - Move tail forward.
         - Advance in the list whose node was selected.
      - After the loop, append the remaining nodes of the non-null list (either list1 or list2).

     c. Flatten All Lists (flattenll)
      - Set merged = listHeads[0] (first list).
      - Loop through listHeads from index 1 to k-1:
         - Merge merged with the current list using mergetwolist.
         - Update merged with the result.
      - Return the fully merged list (merged) at the end.

## Rotate Linked List (Amazon)
### Algorithm:
    a. Handle edge case:
      - If the list is empty (head == null), has only one node (head.next == null), or k <= 0, return head as it is (no rotation needed).
    b. Find the Length of the List and the Last Node:
      - Initialize current = head and length = 1.
      - Traverse the list till you reach the last node (current.next == null).
      - While traversing, increment the length by 1 at each step.
    c. Make the List Circular:
      - After reaching the last node, connect it back to the head (current.next = head).
      - Now the linked list becomes circular.
    d. Adjust k within the Length:
      - Compute k = k % length because rotating by the length of the list brings it back to the original position.
      - Update k = length - k to find the correct number of steps to move forward to break the circle at the correct point.
    e. Find the New Tail:
      - Move current forward by k steps. (while(k-- > 0) current = current.next)
    f. Break the Circle and Update the Head:
      - The next node of current (current.next) becomes the head.
      - Set current.next = null to break the loop and finalize the new list.
    g. Return the Head.


# DOUBLY LINKED LIST
- Forward and Backward Traversal
- Easy at both ends (head and tail)
- More flexible
- More Memory Usage (2pointers per node)

## Delete Occurrence of Key in Doubly Linked List
### Algorithm:
    a. Initialize pointer temp to head
    b. Loop while temp is not null:
       - if temp.val==key:
         - Set nextNode = temp.next
         - Set prevNode = temp.prev
         - if temp == head:
           - Set head = nextNode
           - If head is not null, set head.prev = null
         - else:
           - If prevNode is not null, set prevNode.next = nextNode
           - If nextNode is not null, set nextNode.prev = prevNode
         - Move temp to nextNode
       - Else
         - Move temp = temp.next
    c. Return head
### Time Complexity : O(N)
### Space Complexity : O(1)

