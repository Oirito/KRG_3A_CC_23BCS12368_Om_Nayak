class exp8 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int maxVal = 0;
            int best = 0;

            for (int j = i; j < Math.min(n, i + k); j++) {
                maxVal = Math.max(maxVal, arr[j]);

                int len = j - i + 1;
                best = Math.max(best, maxVal * len + dp[j + 1]);
            }

            dp[i] = best;
        }

        return dp[0];
    }

    public static void main(String[] args) {

    }
}