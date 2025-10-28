import java.util.Scanner;

public class BinaryString {
    public int maxsubstring(String s){
        int maxlength = 1;
        int currentlength = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                currentlength++;
            }else{
                currentlength = 1;
            }
            if(currentlength>maxlength){
                maxlength = currentlength;
            }
        }
        return maxlength;
    }

    private static boolean isBinary(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0' && c != '1') return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of binary string: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the binary string:");
        String binaryString = sc.nextLine();

        if (binaryString.length() != n) {
            System.out.println("Error: String length does not match the entered length!");
            sc.close();
            return;
        }
        if (!isBinary(binaryString)) {
            System.out.println("Error: String must contain only '0' and '1'.");
            sc.close();
            return;
        }

        BinaryString bs = new BinaryString();
        int result = bs.maxsubstring(binaryString);
        System.out.println("The length of the longest substring of identical characters is: " + result);
        sc.close();
    }
}
