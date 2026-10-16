class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); // Empty prefix before index 0 has remainder 0
        int prefixMod = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;
            if (map.containsKey(prefixMod)) {
                if (i- map.get(prefixMod) >= 2) {
                    return true;
                }
                    // Do NOT update firstSeenIndex; we want the earliest index to maximize length
            } 
            else {
                map.put(prefixMod, i);
            }
        }
        return false;
    }
}