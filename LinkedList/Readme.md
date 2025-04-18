# LINKED LIST
Data Structure: Non-contiguous
Memory Allocation: Typically allocated one by one to individual elements
Insertion/Deletion: Efficient
Access: Sequential

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