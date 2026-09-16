class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            if(nums[left]==nums[left+1]){
                return nums[left];
            }

        left++;
        }
        return -1;
    }
}