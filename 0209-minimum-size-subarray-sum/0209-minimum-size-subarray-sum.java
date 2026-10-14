class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    int sum = 0;
    int l=0;
    for (int r = 0; r < nums.length; ++r) {
      sum += nums[r];
      while (sum >= target) {
        min = Math.min(min, r - l + 1);
        sum -= nums[l++];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}