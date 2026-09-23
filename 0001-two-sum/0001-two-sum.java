class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        int left=0;
        int right=1;
        while(right<nums.length){
            if(nums[left]+nums[right]==target){
                arr[0]=left;
                arr[1]=right;
            }
            right++;
            if (right==nums.length){
                left=left+1;
                right=left+1;
            }
        }
        return arr;
    }
}