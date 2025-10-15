import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsequencesString {
    public int printSubsequences(String s, List<String> result){
        if(s.isEmpty()){
            result.add("");
            return 1;
        }
        //char ch = s.charAt(0);
        String ch = s.substring(1);
        int count = printSubsequences(ch, result);
        for(int i=0;i<count;i++){
            result.add(s.charAt(0)+result.get(i));
        }
        return 2*count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.next();
        List<String> result = new ArrayList<>();
        SubsequencesString ss = new SubsequencesString();
        ss.printSubsequences(s,result);
        for(String str: result){
            System.out.println(str);
        }
        sc.close();
    }
}
