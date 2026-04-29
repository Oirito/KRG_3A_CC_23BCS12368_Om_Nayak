import java.util.*;

class Pair {
    int node, weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class prims {

    public static int prims(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
        );
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        int mstWeight = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;
            if (visited[node]) continue;
            visited[node] = true;
            mstWeight += wt;
            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.weight));
                }
            }
        }
        return mstWeight;
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 2, 3},
                {1, 3, 8},
                {1, 4, 5},
                {2, 4, 7}
        };
        int result = prims(V, edges);
        System.out.println("MST Weight: " + result);
    }
}