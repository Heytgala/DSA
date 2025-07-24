import java.util.Scanner;

public class MazeProblem {
    public int pathcount(int[][] maze, int x, int y, String path,int N) {
        int count = 0;
        maze[x][y]=0; //Visited
        if(x == N-1 && y== N-1){
            System.out.println(path);
            count++;
        }
        String directions = "DLRU"; // Down, Left, Right, Up
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0}; 
        for(int i=0;i<directions.length();i++){
            int nexti = x + di[i];
            int nextj = y + dj[i];
            if(nexti>=0 && nextj>=0 && nexti<N && nextj<N && maze[nexti][nextj]==1){
                path += directions.charAt(i);
                count += pathcount(maze, nexti, nextj, path, N);
                path = path.substring(0, path.length() - 1); 
            }
        }
        maze[x][y] = 1;
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the maze dimensions (N x N):");
        int N = scanner.nextInt();
        int[][] maze = new int[N][N];
        System.out.println("Enter the maze (1 for open path,0 for wall):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        MazeProblem mazeProblem = new MazeProblem();
        int pathcount = mazeProblem.pathcount(maze,0,0,"",N);
        System.out.println("Total paths: " + pathcount);
        scanner.close();
    }
}
