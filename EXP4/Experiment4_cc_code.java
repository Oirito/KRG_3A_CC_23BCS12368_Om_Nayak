import java.util.*;

public class Experiment4_cc_code {

    static final long MOD = 1000000007;

    public static long totalPairs(int[] A) {
        long n = A.length;
        long ans = 0;

        for (int bit = 0; bit < 32; bit++) {
            long cnt1 = 0;

            for (int i = 0; i < n; i++) {
                if ((A[i] & (1 << bit)) != 0) {
                    cnt1++;
                }
            }

            long cnt0 = n - cnt1;

            long contribution = (cnt1 * cnt0) % MOD;
            contribution = (2 * contribution) % MOD;

            ans = (ans + contribution) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] A = {2, 7};

        System.out.println(totalPairs(A));
    }
}