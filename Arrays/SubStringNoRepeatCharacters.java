import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubStringNoRepeatCharacters {
    public int Norepeatcharacters(String s){
        int n=s.length();
        int length=0;
        int left=0;
        int right=0;

        Map<Character,Integer> mpp = new HashMap<>();
        while(right<n){
            if(mpp.containsKey(s.charAt(right))){
                left = Math.max(mpp.get(s.charAt(right))+1,left);
            }
            mpp.put(s.charAt(right),right);
            length=Math.max(length,right-left+1);
            right++;
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.next();

        SubStringNoRepeatCharacters rc = new SubStringNoRepeatCharacters();
        int result = rc.Norepeatcharacters(s);

        System.out.println("The longest substring with no repeat characters is "+result);
        sc.close();
        

    }
}
