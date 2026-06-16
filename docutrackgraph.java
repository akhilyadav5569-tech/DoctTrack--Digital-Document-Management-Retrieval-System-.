
import java.util.*;

public class DocuTrackGraph {

    private int V;
    private LinkedList<Integer>[] adj;

    DocuTrackGraph(int v) {
        V = v;
        adj = new LinkedList[v];

        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS Traversal
    void BFS(int start) {

        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {

            int node = queue.poll();
            System.out.print(node + " ");

            for(int n : adj[node]) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // DFS Traversal
    void DFS(int node, boolean visited[]) {

        visited[node] = true;
        System.out.print(node + " ");

        for(int n : adj[node]) {
            if(!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    public static void main(String[] args) {

        DocuTrackGraph g = new DocuTrackGraph(4);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);

        System.out.println("BFS Traversal:");
        g.BFS(0);

        System.out.println("\nDFS Traversal:");

        boolean visited[] = new boolean[4];
        g.DFS(0, visited);
    }
}
