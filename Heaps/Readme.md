# Heaps
- It is complete binary tree (every level is completely filled except the last level) that comes with Heap Order Property.

# 2 Types
1) Min-Heap: 
2) Max-Heap: Parent has its value larger than children.

# Max-Heap : Insertion
``` bash
- Node: ith index
- Left child : 2 * i index
- Right child: 2 * i + 1 index
- Parent: i/2 
```

# Priority Queue 
- It is used for Heap concept. 
- It by default uses Min Heap functionality.
``` bash
-- MIN HEAP
PriorityQueue<int> pq = new PriorityQueue<Integer>();
pq.add(1);
pq.add(4);
pq.add(2);

-- MAX HEAP
PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
pq.add(1);
pq.add(4);
pq.add(3);
```