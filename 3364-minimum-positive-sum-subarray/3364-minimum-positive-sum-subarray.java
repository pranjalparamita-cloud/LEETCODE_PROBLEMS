import java.util.List;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        
        // Enumerate all possible starting indices for the subarray
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Enumerate all possible ending indices for the subarray
            for (int j = i; j < n; j++) {
                currentSum += nums.get(j);
                int length = j - i + 1;
                
                // Check if the length is within the range [l, r] and the sum is positive
                if (length >= l && length <= r && currentSum > 0) {
                    minSum = Math.min(minSum, currentSum);
                }
            }
        }
        
        // If minSum wasn't updated, no valid subarray was found
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}