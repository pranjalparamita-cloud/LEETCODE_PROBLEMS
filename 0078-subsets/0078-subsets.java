class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        backtrack(0, new ArrayList<>(), nums, result);
        return result; 
    }
    
    private void backtrack(int start, List<Integer> current, int[] nums, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) { 
            current.add(nums[i]);
            backtrack(i + 1, current, nums, result);
            current.remove(current.size() - 1);
        }
    }
}