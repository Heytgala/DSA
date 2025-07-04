import java.util.Scanner;

public class LongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxlength = 0;
        int maxcount = 0;
        int[] freq = new int[26];
        
        for(right=0;right<s.length();right++){
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxcount = Math.max(maxcount, freq[idx]);

            int windowSize = right - left + 1;

            if (windowSize - maxcount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            } else {
                maxlength = Math.max(maxlength, windowSize);
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        System.out.print("Enter the maximum number of characters to replace (k): ");
        int k = scanner.nextInt();
        LongestRepeatingCharacter lrc = new LongestRepeatingCharacter();
        int result = lrc.characterReplacement(s, k);
        System.out.println("Length of the longest substring: " + result);
        scanner.close();
    }
}
