import java.util.Scanner;

public class BasicProblems {
    // Case 1: Sum of numbers using recursion
    public int sumofNumbershelpers(int[] nums,int index){
        if(index<0){
            return 0;
        }
        return nums[index] + sumofNumbershelpers(nums, index-1);
    }
    public int sumofNumbers(int[] nums,int n){
        return sumofNumbershelpers(nums,n-1);
    }
    // Case 2: Factorial of a number using recursion
    public int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n * factorial(n-1);
    }

    // Case 3: Reverse an array using recursion
    public int[] reversearray(int[] arr){
        int n = arr.length;
        reversearrayhelpers(arr,0,n-1);
        return arr;
    }

    public void reversearrayhelpers(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reversearrayhelpers(arr, start + 1, end - 1);
    }

    // Case 4: Check if a string is a palindrome using recursion
    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        return isPalindromeHelper(str, left, right);
    }
    private boolean isPalindromeHelper(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return isPalindromeHelper(str, left + 1, right - 1);
    }

    // Case 5: Multiple Recursion - Fibonacci Series
    public int fibonacci(int n) {
        if(n<=1){
            return n;
        }
        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);
        return last + secondLast;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BasicProblems problems = new BasicProblems();
        System.out.println("Choose an option:");
        System.out.println("1. Sum of numbers");
        System.out.println("2. Factorial of a number");
        System.out.println("3. Reverse an array");
        System.out.println("4. Palindrome");
        System.out.println("5. Multiple Recursion - Fibonacci Series");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter the total numbers you want to add:");
                int n = sc.nextInt();
                int[] arr = new int[n];
                System.out.println("Enter the numbers:");
                for(int i=0;i<n;i++){
                    arr[i] = sc.nextInt();
                }
                int result = problems.sumofNumbers(arr,n);
                System.out.println("The sum of the numbers is: " + result);
                break;
            case 2:
                System.out.print("Enter the number to find factorial: ");
                int num = sc.nextInt();
                int resultFactorial = problems.factorial(num);
                System.out.println("The factorial of " + num + " is: " + resultFactorial);
                break;
            case 3:
                System.out.print("Enter the size of the array: ");
                int size = sc.nextInt();
                int[] array = new int[size];
                System.out.println("Enter the elements of the array:");
                for (int i = 0; i < size; i++) {
                    array[i] = sc.nextInt();
                }
                int[] reversedArray = problems.reversearray(array);
                System.out.print("Reversed array: ");
                for (int i = 0; i < reversedArray.length; i++) {
                    System.out.print(reversedArray[i] + " ");
                }
                break;
            case 4:
                System.out.print("Enter a string to check for palindrome: ");
                sc.nextLine();
                String str = sc.nextLine();
                boolean output = problems.isPalindrome(str);
                if (output) {
                    System.out.println(str + " is a palindrome.");
                } else {
                    System.out.println(str + " is not a palindrome.");
                }
                break;
            case 5:
                System.out.println("Enter the number");
                int numbr = sc.nextInt();
                int fib = problems.fibonacci(numbr);
                System.out.println("The Fibonacci number at position " + numbr + " is: " + fib);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        sc.close();
    }
}
