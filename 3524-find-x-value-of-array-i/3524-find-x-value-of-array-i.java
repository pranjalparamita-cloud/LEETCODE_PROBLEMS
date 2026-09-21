class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int x = num % k;
            long[] next = new long[k];

            next[x] = 1;

            for (int i = 0; i < k; i++) {
                int r = (i * x) % k;
                next[r] += dp[i];
            }

            for (int i = 0; i < k; i++) {
                ans[i] += next[i];
            }

            dp = next;
        }

        return ans;
    }
}