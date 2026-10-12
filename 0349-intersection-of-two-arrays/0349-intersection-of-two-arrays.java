class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[Math.min(n, m)];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    boolean found = false;

                    for (int x = 0; x < k; x++) {
                        if (arr[x] == nums1[i]) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        arr[k] = nums1[i];
                        k++;
                    }

                    break;
                }
            }
        }

        return java.util.Arrays.copyOf(arr, k);
    }
}