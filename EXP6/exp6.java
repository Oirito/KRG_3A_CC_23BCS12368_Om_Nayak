import java.util.*;

public class exp6{
    static List<Integer>[] graph = new ArrayList[26];
    static int[] indegree = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int i = 0; i < n - 1; i++) {
            String a = words[i];
            String b = words[i + 1];

            if (a.length() > b.length() && a.startsWith(b)) {
                System.out.println("Impossible");
                return;
            }

            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    int u = a.charAt(j) - 'a';
                    int v = b.charAt(j) - 'a';

                    graph[u].add(v);
                    indegree[v]++;
                    break;
                }
            }
        }

        // Topological Sort (Kahn's Algo)
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!q.isEmpty()) {
            int u = q.poll();
            res.append((char)(u + 'a'));

            for (int v : graph[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        if (res.length() != 26) {
            System.out.println("Impossible");
        } else {
            System.out.println(res.toString());
        }
    }
}