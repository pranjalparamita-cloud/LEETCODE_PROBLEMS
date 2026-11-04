import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] minOps = getMinOps(nums, x);
        
        // Memoization table for DP: dp[i][remK]
        Long[][] memo = new Long[n + 1][k + 1];
        
        return dp(0, k, n, x, minOps, memo);
    }
    
    private long dp(int i, int remK, int n, int x, long[] minOps, Long[][] memo) {
        if (remK == 0) return 0;
        if (i > n || n - i < (long) remK * x) return (long) 1e18; // Impossible case
        if (memo[i][remK] != null) return memo[i][remK];
        
        // Option 1: Skip index i
        long skip = dp(i + 1, remK, n, x, minOps, memo);
        
        // Option 2: Pick a window of size x starting at index i
        long pick = (long) 1e18;
        if (i + x <= n) {
            pick = minOps[i] + dp(i + x, remK - 1, n, x, minOps, memo);
        }
        
        return memo[i][remK] = Math.min(skip, pick);
    }
    
    private long[] getMinOps(int[] nums, int x) {
        int n = nums.length;
        long[] minOps = new long[n];
        
        // Using TreeMaps acting as multisets to maintain lower and upper halves
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();
        long lowerSum = 0, upperSum = 0;
        int lowerSize = 0, upperSize = 0;
        
        for (int i = 0; i < n; i++) {
            // Insert nums[i]
            if (lowerSize == 0 || nums[i] <= lower.lastKey()) {
                lower.put(nums[i], lower.getOrDefault(nums[i], 0) + 1);
                lowerSum += nums[i];
                lowerSize++;
            } else {
                upper.put(nums[i], upper.getOrDefault(nums[i], 0) + 1);
                upperSum += nums[i];
                upperSize++;
            }
            
            // Remove out-of-window element
            if (i >= x) {
                int outNum = nums[i - x];
                if (lower.containsKey(outNum)) {
                    lowerSum -= outNum;
                    lowerSize--;
                    removeElement(lower, outNum);
                } else {
                    upperSum -= outNum;
                    upperSize--;
                    removeElement(upper, outNum);
                }
            }
            
            // Balance sizes
            if (lowerSize < upperSize) {
                int val = upper.firstKey();
                removeElement(upper, val);
                upperSum -= val;
                upperSize--;
                
                lower.put(val, lower.getOrDefault(val, 0) + 1);
                lowerSum += val;
                lowerSize++;
            } else if (lowerSize - upperSize > 1) {
                int val = lower.lastKey();
                removeElement(lower, val);
                lowerSum -= val;
                lowerSize--;
                
                upper.put(val, upper.getOrDefault(val, 0) + 1);
                upperSum += val;
                upperSize++;
            }
            
            // Calculate cost once window size is reached
            if (i >= x - 1) {
                long median = lower.lastKey();
                minOps[i - x + 1] = (median * lowerSize - lowerSum) + (upperSum - median * upperSize);
            }
        }
        
        long[] fullMinOps = new long[n];
        for (int i = 0; i <= n - x; i++) {
            fullMinOps[i] = minOps[i];
        }
        return fullMinOps;
    }
    
    private void removeElement(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }
}