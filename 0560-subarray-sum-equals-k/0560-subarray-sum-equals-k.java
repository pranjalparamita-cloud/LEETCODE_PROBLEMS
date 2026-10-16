class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixsum=0;
        int totalsubarray=0;
        for (int num:nums){
            prefixsum+=num;
            totalsubarray+=map.getOrDefault(prefixsum-k,0);
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return totalsubarray;
    }
}