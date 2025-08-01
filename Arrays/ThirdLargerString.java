import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class ThirdLargerString {
    
    class WordCandidate {
        String word;
        int index;
        int length;

        WordCandidate(String word, int index) {
            this.word = word;
            this.index = index;
            this.length = word.length();
        }
    }   
    public String ArrayChallenge(String[] strArr) {
        // TreeMap to keep word lengths sorted in descending order
        TreeMap<Integer, List<WordCandidate>> lengthMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < strArr.length; i++) {
            String word = strArr[i];
            int len = word.length();
            lengthMap.putIfAbsent(len, new ArrayList<>());
            lengthMap.get(len).add(new WordCandidate(word, i));
        }

        List<WordCandidate> combined = new ArrayList<>();

        // Merge all WordCandidates from longest to shortest length
        for (Map.Entry<Integer, List<WordCandidate>> entry : lengthMap.entrySet()) {
            List<WordCandidate> sameLengthWords = entry.getValue();

            // For words of same length, preserve original order (i.e., as per index)
            sameLengthWords.sort(Comparator.comparingInt(w -> w.index));

            combined.addAll(sameLengthWords);
        }

        // Return 3rd largest if exists
        if (combined.size() >= 3) {
            return combined.get(2).word;
        } else {
            // Fewer than 3 words, return last one (or anything valid)
            return combined.get(combined.size() - 1).word;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] strArr = s.nextLine().trim().split("\\s+");
        ThirdLargerString obj = new ThirdLargerString();
        String result = obj.ArrayChallenge(strArr);
        System.out.println(result);
        s.close();
    }
}
