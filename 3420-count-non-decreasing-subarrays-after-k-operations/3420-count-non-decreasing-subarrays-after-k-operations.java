import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long ops = 0;
        int r = n - 1;
        
        // Monotonic decreasing deque storing pairs of {value, count_of_elements_governed}
        Deque<long[]> dq = new ArrayDeque<>();
        
        for (int l = n - 1; l >= 0; l--) {
            long count = 1;
            
            // Merge smaller/equal elements to the right into nums[l]'s dominance range
            while (!dq.isEmpty() && dq.peekLast()[0] <= nums[l]) {
                long[] last = dq.pollLast();
                ops += (nums[l] - last[0]) * last[1];
                count += last[1];
            }
            dq.addLast(new long[]{nums[l], count});
            
            // Shrink the window from the right while operations exceed k
            while (ops > k) {
                long[] first = dq.peekFirst();
                ops -= (first[0] - nums[r]);
                first[1]--;
                if (first[1] == 0) {
                    dq.pollFirst();
                }
                r--;
            }
            
            // Every subarray [l..j] for l <= j <= r is valid
            ans += (r - l + 1);
        }
        
        return ans;
    }
}