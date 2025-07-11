import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int[] leftrow = new int[n];
        int[] upperdiagonal = new int[2*n-1];
        int[] lowerdiagonal = new int[2*n-1];
        solve(0,board,result,leftrow,upperdiagonal,lowerdiagonal);
        return result;
    }

    public void solve(int index, char[][] board, List<List<String>> result,int[] leftrow,int[] upperdiagonal,int[] lowerdiagonal){
        if(index == board.length) {
            result.add(construct(board));
            return;
        }

        for(int i=0;i<board.length;i++){
            if (leftrow[i] == 0 && lowerdiagonal[i + index] == 0 && upperdiagonal[board.length - 1 + index - i] == 0) {
                board[i][index] = 'Q';
                leftrow[i] = 1;
                lowerdiagonal[i + index] = 1;
                upperdiagonal[board.length - 1 + index - i] = 1;
                solve(index + 1, board, result, leftrow, upperdiagonal, lowerdiagonal);
                board[i][index] = '.';
                leftrow[i] = 0;
                lowerdiagonal[i + index] = 0;
                upperdiagonal[board.length - 1 + index - i] = 0;
            }
        }
    }

    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = scanner.nextInt();
        NQueens nQueens = new NQueens();
        List<List<String>> solutions = nQueens.solveNQueens(n);
        System.out.println("Number of solutions for " + n + "-Queens: " + solutions.size());
        for (List<String> solution : solutions) {
            System.out.println(solution);
        }
        scanner.close();
    }
}
