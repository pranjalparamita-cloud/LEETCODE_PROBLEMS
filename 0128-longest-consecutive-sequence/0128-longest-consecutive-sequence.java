class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        int longest = 0;
        for (int num : map.keySet()) {
            if (!map.containsKey(num - 1)) {
                int current = num;
                int count = 1;
                while (map.containsKey(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}