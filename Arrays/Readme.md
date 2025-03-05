# BINARY SEARCH
- It eliminates one half of the array.
1) Iterative Method - 2 pointers approach & It will always be sorted array; Best for large dataset and efficient performance in memory.
2) Recursion Method - uses function recursion; slightly slower due to function call overhead.

# Rotated Sorted Array 
- Elements will be always unique 
- Search and Sorted always relate to Binary Search
- Eg. [7 8 9 1 2 3 4] target=3 find index value if it exists or else return -1

# Peak Element in 2D grid
- an element that is strictly greater than all of its adjacent neighbors (left, right, top, bottom). The task is to find any peak element and return its coordinates [i, j].
- Optimal Solution : Binary Search - Time Complexity (O(m log n))

# 4-Sum Problem
- 2 pointers with Sorting

# Merge Sort
- uses Divide and Merge Concept
- We can use recursion method 
- Always O(n log n), regardless of input order.

# Reverse Pairs
- Rule ("i"<"j") && (a[i] > 2 * a[j])
- Use Merge Sort method 
- TC : O(2nlogn) & SC: O(n)
 

# DYNAMIC PROGRAMMING
- Used to store answer to various sub-problems.
- 2 approaches: 
    a. Memoization: top-down approach -- Used for Overlapping subproblems
    b. Tabulation: bottom-up approach
- When to use 
    - Count total no of ways
    - Minimal or Maximal output
- Trick 
    - Try to represent problem in terms of index
    - Do all possible stuff on index accoridng to problem statement
    - Sum of all stuffs = count all ways
    - Min of all stuffs = to find min

# Shortest Common Supersequence
- Compute LCS: Using dynamic programming to build the LCS table (dp).
- Construct SCS from LCS: Trace back through the LCS table to merge the strings into the shortest supersequence.

# Minimum Path Sum -- Microsoft Interview Question
- Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
- Dynamic Programming problem
