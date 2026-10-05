class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> lolo=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int rnum=target-num;
            if(lolo.containsKey(rnum)){
                return new int[]{lolo.get(rnum),i};
            }
            lolo.put(num,i);
        }
        return new int[]{};
    }
}