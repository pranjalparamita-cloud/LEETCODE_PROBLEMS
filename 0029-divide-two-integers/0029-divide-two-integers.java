class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;

        if ((dividend < 0) ^ (divisor < 0)) {
            sign = -1;
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long ans = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            long count = 1;

            while ((temp << 1) <= dvd) {
                temp = temp << 1;
                count = count << 1;
            }

            dvd = dvd - temp;
            ans = ans + count;
        }

        if (sign == -1) {
            return -(int) ans;
        }

        return (int) ans;
    }
}