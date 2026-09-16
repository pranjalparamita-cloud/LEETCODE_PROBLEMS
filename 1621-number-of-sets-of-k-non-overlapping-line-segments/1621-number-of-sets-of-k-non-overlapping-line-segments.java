class Solution {
    public int numberOfSets(int n, int k) {
        long ans = 1;
        int MOD = 1000000007;

        // Answer = C(n + k - 1, 2k)
        int N = n + k - 1;
        int R = 2 * k;

        for (int i = 1; i <= R; i++) {
            ans = ans * (N - R + i) % MOD;
            ans = ans * modInverse(i, MOD) % MOD;
        }

        return (int) ans;
    }

    private long modInverse(long x, int MOD) {
        return power(x, MOD - 2, MOD);
    }

    private long power(long x, long n, int MOD) {
        long result = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                result = result * x % MOD;
            }

            x = x * x % MOD;
            n /= 2;
        }

        return result;
    }
}