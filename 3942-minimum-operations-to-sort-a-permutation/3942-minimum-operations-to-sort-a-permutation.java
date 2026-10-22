import java.util.function.IntPredicate;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;
        
        // Find the index of 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        
        // Helper to check if elements follow a valid step pattern
        final int finalZero = zero;
        IntPredicate check = step -> {
            for (int i = 1; i < n; i++) {
                int prev = (finalZero + (i - 1) * step + n) % n;
                int curr = (finalZero + i * step + n) % n;
                if (nums[prev] > nums[curr]) {
                    return false;
                }
            }
            return true;
        };
        
        int ans = Integer.MAX_VALUE;
        
        // Check increasing order with step = 1
        if (check.test(1)) {
            ans = Math.min(ans, zero);         // only left rotations
            ans = Math.min(ans, n - zero + 2); // reverse, left rotate, reverse
        }
        
        // Check decreasing order / reverse compatibility with step = -1
        if (check.test(-1)) {
            ans = Math.min(ans, zero + 2);     // left rotate, then reverse
            ans = Math.min(ans, n - zero);     // reverse, then left rotate
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}