import java.util.*;

public class Exp_kmp {

    public static void main(String[] args) {

        String pattern = "cba";
        String s = "abcabcbadbbcba";

        int m = pattern.length();
        int n = s.length();

        int[] lps = new int[m];

        int length = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        i = 0;
        int j = 0;

        while (i < n) {

            if (pattern.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }
            else if (i < n && pattern.charAt(j) != s.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }
}