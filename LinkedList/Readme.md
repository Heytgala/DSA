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

