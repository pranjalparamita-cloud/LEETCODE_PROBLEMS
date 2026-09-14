class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int water=0;
        int max_left=0;
        int max_right=0;
        while(l<r){
            if(height[l]>height[r]){
                if (height[r]>=max_right){
                    max_right=height[r];
                }
                else{
                water=water+(max_right-height[r]);
                }
                r--;
            }
            else{
                if (height[l]>=max_left){
                    max_left=height[l];
                }
                else{
                    water=water+(max_left-height[l]);
                }
                l++;
            }
        }
        return water;
    }
}