import java.util.*;

class Solution {

    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public int nthMagicalNumber(int n, int a, int b) {

        long low = Math.min(a, b);
        long high = (long) n * Math.min(a, b);
        long L = lcm(a, b);

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = mid / a + mid / b - mid / L;

            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) low;
    }
}

public class Experiment1_cc_code {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        Solution obj = new Solution();
        int result = obj.nthMagicalNumber(n, a, b);

        System.out.println("Nth Magical Number: " + result);

        sc.close();
    }
}