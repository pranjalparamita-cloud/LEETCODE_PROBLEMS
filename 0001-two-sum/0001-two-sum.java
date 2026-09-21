class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        int left=0;
        int right=1;
        while(left<nums.length){
            if(nums[left]+nums[right]==target){
                arr[0]=left;
                arr[1]=right;
                return arr;

            }
            right++;
            if(right==nums.length){
                left++;
                right=left+1;
            }
        }
        return arr;
    }
}