import java.util.*;

class exp7 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>())
                    .add(new int[]{f[1], f[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0}); // node, cost, stops

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (stops > k) continue;

            if (!graph.containsKey(node)) continue;

            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int price = nei[1];

                if (cost + price < dist[next]) {
                    dist[next] = cost + price;
                    q.offer(new int[]{next, dist[next], stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {

    }
}