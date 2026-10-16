class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int currentmax=0;
        int currentmin=0;
        int maxsum=Integer.MIN_VALUE;
        int minsum=Integer.MAX_VALUE;
        for(int num:nums){
            currentmax=Math.max(num,currentmax+num);
            currentmin=Math.min(num,currentmin+num);
            maxsum=Math.max(maxsum,currentmax);
            minsum=Math.min(minsum,currentmin);
            total+=num;
        }
        if (maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,total-minsum);
    }
}