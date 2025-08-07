class Solution {
    public double myPow(double x, int n) {
        long N = n;

        
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
