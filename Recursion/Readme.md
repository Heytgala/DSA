# RECURSION
- When the function calls itself until the specific condition is met.
- Base condition is main necessary need for function to not go in infinite loop.

## Count-Based Recursion (Foundation of Dynamic Programming)
```cpp
int function() {
    // base case
    if (/* condition satisfied */) return 1;
    if (/* condition not satisfied */) return 0;

    int left = function();   // recursive call for one option
    int right = function();  // recursive call for another option

    return left + right;     // total ways from both options
}
```