class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            if (nums[l]>=target){
                return l;
            }
            l++;
        }
    return nums.length;
    }
}