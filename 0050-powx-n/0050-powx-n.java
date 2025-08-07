class Solution {
    public double myPow(double x, int n) {
        // Convert n to long to avoid overflow when n == Integer.MIN_VALUE
        long N = n;

        // Handle negative power
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        if (N == 0) {
            return 1;
        }

        double halfpow = myPow(x, (int)(N / 2));
        double halfsq = halfpow * halfpow;

        if (N % 2 != 0) {
            halfsq = x * halfsq;
        }

        return halfsq;
    }
}
