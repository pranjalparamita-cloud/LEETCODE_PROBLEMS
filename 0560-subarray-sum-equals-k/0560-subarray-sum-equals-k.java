class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prevnum=0;
        int total=0;
        for(int num:nums){
            prevnum+=num;
            total+=map.getOrDefault(prevnum-k,0);
            map.put(prevnum,map.getOrDefault(prevnum,0)+1);
        }
        return total;
    }
}