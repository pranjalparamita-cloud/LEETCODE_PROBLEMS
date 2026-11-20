class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            if(nums[left]<nums[right]){
                return nums[left];
            }
        left++;
        }
        return nums[right];
    }
}