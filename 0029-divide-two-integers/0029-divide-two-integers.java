class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if ((dividend >= 0) && (divisor < 0)|| (dividend <= 0) && (divisor > 0)) {
            sign = -1;
        }
        
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        long ans = 0;

        while (dvd >= dvs) {
            long count = 0;
            while (dvd >= (dvs << (count + 1))) {
                count++;
            }
            ans += (1L << count);
            dvd -= (dvs << count);
        }

        if (sign == -1) {
            return -(int) ans;
        }
        return (int) ans;
    }
}