class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int m:nums){
            map.put(m,true);
        }
        int longest=0;
        for(int num:map.keySet()){
            if (!map.containsKey(num-1)){
                int current=num;
                int count=1;
                while(map.containsKey(current+1)){
                    current++;
                    count+=1;
                }
                longest=Math.max(count,longest);
            }
        }
        return longest;
    }
}