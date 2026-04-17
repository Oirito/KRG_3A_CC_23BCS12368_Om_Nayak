class exp3 {
    public int nthMagicalNumber(int n, int a, int b) {
        long mod = 1000000007;

        long left = 1, right = (long) n * Math.min(a, b);

        long lcm = (long) a * b / gcd(a, b);

        while (left < right) {
            long mid = left + (right - left) / 2;

            long count = mid / a + mid / b - mid / lcm;

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left % mod);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}