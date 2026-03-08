import java.util.*;

public class Experiment5_cc_code {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<String> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            st.add(s);
        }

        while (m-- > 0) {
            String s = sc.next();
            boolean found = false;

            char[] arr = s.toCharArray();

            for (int i = 0; i < arr.length && !found; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'c'; ch++) {

                    if (ch == original) continue;

                    arr[i] = ch;

                    if (st.contains(new String(arr))) {
                        found = true;
                        break;
                    }
                }

                arr[i] = original;
            }

            if (found)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}