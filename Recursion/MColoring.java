import java.util.ArrayList;
import java.util.List;

public class MColoring {
    public boolean isSafe(List<Integer>[] G, int[] color, int node, int c) {
        for (int neighbor : G[node]) {
            if (color[neighbor] == c) {
                return false; 
            }
        }
        return true; 
    }

    public boolean graphColoring(List<Integer>[] G, int[] color, int node, int M){
        if(node== G.length) {
            return true; 
        }
        for(int c=1;c<=M;c++){
            if(isSafe(G, color, node, c)){
                color[node] = c; 
                if(graphColoring(G, color, node + 1, M)) {
                    return true; 
                }
                color[node] = 0; 
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int N = 4, M = 3;
        List <Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList < > ();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        MColoring mColoring = new MColoring();
        boolean ans = mColoring.graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
