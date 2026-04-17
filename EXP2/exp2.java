import java.util.*;

class exp2 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;

        int max = 0;

        for(int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int same = 1;

            for(int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if(dx == 0 && dy == 0) {
                    same++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String key = dx + "," + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int localMax = 0;
            for(int val : map.values()) {
                localMax = Math.max(localMax, val);
            }

            max = Math.max(max, localMax + same);
        }

        return max;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}