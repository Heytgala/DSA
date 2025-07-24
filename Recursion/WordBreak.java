import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class WordBreak {
    public static boolean wordbreak(String s, List<String> dict){
        Set<String> wordset = new HashSet<>(dict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return canBreak(s,0,wordset,memo);
    };

    public static boolean canBreak(String s,int start, Set<String> wordset, Map<Integer, Boolean> memo) {
        if(start==s.length()) {
            return true;
        }
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        for(int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if(wordset.contains(word) && canBreak(s, end, wordset, memo)) {
                memo.put(start, true);
                return true;
            }
        }
        memo.put(start, false);
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to be checked:");
        String s = scanner.nextLine();
        System.out.println("Enter the number of words in the dictionary:");
        int n = scanner.nextInt();
        List<String> dict = new ArrayList<>(n);
        System.out.println("Enter the words in the dictionary:");
        for (int i = 0; i <= n; i++) {
            dict.add(scanner.nextLine());
        }
        WordBreak wb = new WordBreak();
        if (wb.wordbreak(s, dict)) {
            System.out.println("The string can be segmented into words from the dictionary.");
        } else {
            System.out.println("The string cannot be segmented into words from the dictionary.");
        }
        scanner.close();
    }
}
