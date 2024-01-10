class Solution {
    public double myPow(double x, int n) {
        double pow = 1.0;
        long p = n;
        if (n < 0) p *= -1;

        while (p > 0) {
            if (p % 2 == 1) {
                pow = pow * x;
            }
            p /= 2;
            x *= x;
        }

        return n < 0 ? 1 / pow : pow;
    }
}