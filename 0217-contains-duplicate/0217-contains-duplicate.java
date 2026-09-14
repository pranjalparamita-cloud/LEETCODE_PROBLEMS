class Solution {
    public boolean containsDuplicate(int[] nums) {
         Arrays.sort(nums);
         int l=0;
         int r=1;
         while(r<nums.length){
            if (nums[l]==nums[r]){
                return true;
            }
            l++;
            r++;
         } return false;
    }
}