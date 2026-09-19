class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        int l=0;
        int r=1;
        while (l<nums.length) {
            if (nums[l]+nums[r]==target) {
                arr[0]=l;
                arr[1]=r;
               return arr;
            }
            r++;
            if (r==nums.length) {
                l++;
                r=l+1;
            }
        }
        return arr;
    }
}