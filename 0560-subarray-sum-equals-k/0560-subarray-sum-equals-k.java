class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixsum=0;
        int total=0;
        map.put(0,1);
        for(int num:nums){
            prefixsum+=num;
            total+=map.getOrDefault(prefixsum-k,0);
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return total;
    }
}