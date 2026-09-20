class Solution {
    public int reversePairs(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }
    int solve(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        int ans = solve(nums, l, mid);
        ans += solve(nums, mid + 1, r);
        int j = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (j <= r && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            ans += j - mid - 1;
        }
        Arrays.sort(nums, l, r + 1);
        return ans;
    }
}