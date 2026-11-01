class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        // Find the minimum element in the array
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        
        // Calculate total moves needed to bring all elements down to the minimum
        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }
        
        return moves;
    }
}