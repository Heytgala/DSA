import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        divide(s,0,new ArrayList<>(), result);
        return result;
    }

    public void divide(String s, int index, List<String> ds, List<List<String>> result){
        if(index==s.length()){
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                divide(s,i+1,ds,result);
                ds.remove(ds.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int index,int i){
        while(index<=i){
            if(s.charAt(index++) != s.charAt(i--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        PalindromePartition pp = new PalindromePartition();
        List<List<String>> result = pp.partition(s);
        // Print the result
        // System.out.println("Input string: " + s);
        // if (result.isEmpty()) {
        //     System.out.println("No palindrome partitions found.");
        //     return;
        // }
        System.out.println("Palindrome partitions: " + result);
        scanner.close();
    }
}
