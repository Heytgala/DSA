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

# Largest Sub Array sum
- contigeous part of array
- Using Prefix Sum & HashMap concept for optimal solution
- TC: O(N) & SC: O(N)

# Merge Sort
- uses Divide and Merge Concept
- We can use recursion method 
- Always O(n log n), regardless of input order.


# Count Inversion
- Use Merge Sort Method
- TC: O(n log(n))
- SC: O(n) -- Distorting/Altering the array instead of copying the data

# Reverse Pairs
- Rule ("i"<"j") && (a[i] > 2 * a[j])
- Use Merge Sort method 
- TC : O(2nlogn) & SC: O(n)

# Repeat and Inverse Numbers (Missing)
- 2 Optimal approaches
  - Math
    1) Summation of n numbers
    2) summation of squares of n numbers
  - XOR
    1) XOR all elements in array and numbers between 1 and N.
    2) In order to find the position of the first set bit from the right, we can either use a loop or we can perform AND of the xr and negation of (xr-1) i.e. (xr & ~(xr-1)).
    3) Now, we will take two variables i.e. zero and one. Now, we will check the bit of that position for every element (array elements as well as numbers between 1 to N).
        -> If the bit is 1: We will XOR that element with variable one.
        -> If the bit is 0: We will XOR that element with variable zero.
    4) Finally, we have two variables i.e. two numbers zero and one. Among them, one is repeating and the other is missing. It’s time to identify them. 
        -> We will traverse the entire array and check how many times variable zero appears. 
        -> If it appears twice, it will be the repeating number, otherwise, it will be the missing. Now, based on variable zero’s identity, we can easily identify in which category, variable one belongs.
 

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
