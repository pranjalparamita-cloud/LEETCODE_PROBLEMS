import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Create a 2D array to store {digit_sum, value} for each element
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = getDigitSum(nums[i]);
            items[i][1] = nums[i];
        }
        
        // Sort based on primary key (digit sum) and secondary key (value)
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        // Map each value to its target sorted index
        Map<Integer, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndex.put(items[i][1], i);
        }
        
        // Find the number of cycles to compute minimum swaps (n - cycles)
        boolean[] vis = new boolean[n];
        int cycles = 0;
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cycles++;
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    j = targetIndex.get(nums[j]);
                }
            }
        }
        
        return n - cycles;
    }
}