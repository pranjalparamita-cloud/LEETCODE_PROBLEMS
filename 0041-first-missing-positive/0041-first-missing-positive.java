class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int min=1;
        while (l<nums.length){
            if (nums[l]== min){
                min++;
            }
            l++;
        }
        return min;

    }
}