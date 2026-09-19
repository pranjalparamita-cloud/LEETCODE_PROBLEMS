class Solution {
    public int[] relativeSortArray(int[] arr1,int[] arr2) {
        int[] ans=new int[arr1.length];
        int k=0;
        for (int i=0;i<arr2.length;i++) {
            for (int j=0;j<arr1.length;j++) {
                if (arr1[j]==arr2[i]) {
                    ans[k]=arr1[j];
                    k++;
                }
            }
        }
        Arrays.sort(arr1);
        for (int i=0;i<arr1.length;i++) {
            boolean found=false;

            for (int j=0;j<arr2.length;j++) {
                if (arr1[i]==arr2[j]) {
                    found=true;
                }
            }
            if (!found){
                ans[k]=arr1[i];
                k++;
            }
        }
        return ans;
    }
}