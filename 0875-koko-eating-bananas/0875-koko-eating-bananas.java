class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int hi=0;
        for(int p:piles){
            hi=Math.max(hi,p);
        }
        while(low<hi){
            int mid=low+(hi-low)/2;
            if (cat(piles,h,mid)){
                hi=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean  cat(int[] piles,int h,int speed){
        long hrs=0;
        for(int p:piles){
            hrs+=(p+speed-1)/speed;
        }
        if (hrs>h){
            return false;
        }
        return hrs<=h;
    }
}