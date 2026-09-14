class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l=0;
        while(l<n){
            if (nums2[l]!=0){
                nums1[m]=nums2[l];
                m++;
            }
            l++;  
        }
    Arrays.sort(nums1);
    }    
}