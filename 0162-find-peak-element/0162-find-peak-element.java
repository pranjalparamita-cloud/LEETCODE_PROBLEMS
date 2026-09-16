class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]>nums[left+1]){
                return left;
            }
            left++;
        }
        return right;
    }
}