import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public int findCelebrity(int[][] knows) {
        int n = knows.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int A = stack.pop();
            int B = stack.pop();

            if (knows[A][B] == 1) {
                stack.push(B);
            } else {
                stack.push(A);
            }
        }

        if (stack.isEmpty()) return -1;
        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (knows[candidate][i] == 1 || knows[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int n = scanner.nextInt();
        int[][] knows = new int[n][n];
        System.out.println("Enter the knows matrix (0 or 1):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                knows[i][j] = scanner.nextInt();

        CelebrityProblem cp = new CelebrityProblem();
        int celeb = cp.findCelebrity(knows);
        System.out.println((celeb == -1) ? "No celebrity found." : "Celebrity is person: " + celeb);
        scanner.close();
    }
}
