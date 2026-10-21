class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // If length is 2 and not sorted, it's impossible
        if (n == 2) return -1;
        
        int minIdx = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < s.charAt(minIdx)) {
                minIdx = i;
            }
            if (s.charAt(i) >= s.charAt(maxIdx)) {
                maxIdx = i;
            }
        }
        
        // If the smallest element starts at index 0 or the largest is at the end
        if (minIdx == 0 || maxIdx == n - 1) {
            return 1;
        }
        
        // If smallest is at the very end and largest is at the very beginning
        if (minIdx == n - 1 && maxIdx == 0) {
            return 3;
        }
        
        // Default case for remaining scenarios
        return 2;
    }
}