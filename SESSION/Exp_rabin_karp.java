import java.util.*;

public class Exp_rabin_karp {

    static void rabinKarp(String txt, String pattern) {

        int n = txt.length();
        int m = pattern.length();

        int d = 26;
        long mod = 1000000007;

        long pHash = 0;
        long tHash = 0;
        long h = 1;

        for (int i = 0; i < m - 1; i++)
            h = (h * d) % mod;

        for (int i = 0; i < m; i++) {
            pHash = (d * pHash + (pattern.charAt(i) - 'a' + 1)) % mod;
            tHash = (d * tHash + (txt.charAt(i) - 'a' + 1)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {

            if (pHash == tHash) {
                if (txt.substring(i, i + m).equals(pattern))
                    System.out.println("Pattern found at index " + i);
            }

            if (i < n - m) {
                tHash = (d * (tHash - (txt.charAt(i) - 'a' + 1) * h)
                        + (txt.charAt(i + m) - 'a' + 1)) % mod;

                if (tHash < 0)
                    tHash += mod;
            }
        }
    }

    public static void main(String[] args) {

        String txt = "abcabcbad";
        String pattern = "cba";

        rabinKarp(txt, pattern);
    }
}