class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(nums,0,result,new ArrayList<>());
        return result;
    }
    public void backtrack(int[] nums, int index,List<List<Integer>> result, List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(nums,i+1,result,current);
            current.remove(current.size()-1);
        }
    }
}