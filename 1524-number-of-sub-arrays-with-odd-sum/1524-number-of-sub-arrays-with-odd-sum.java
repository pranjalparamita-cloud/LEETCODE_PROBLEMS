class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        // count[0] tracks even prefix sums, count[1] tracks odd prefix sums
        // Initialize count[0] = 1 for the base case (prefix sum 0)
        int[] count = new int[] {1, 0}; 
        int prefixSum = 0;
        int result = 0;
        
        for (int num : arr) {
            prefixSum += num;
            
            // The parity of the current prefix sum
            int currentParity = prefixSum % 2;
            // The opposite parity needed to get an odd subarray sum
            int requiredParity = currentParity ^ 1;
            
            // Add the count of the required parity to our result
            result = (result + count[requiredParity]) % MOD;
            
            // Increment the count for the current prefix sum's parity
            count[currentParity]++;
        }
        
        return result;
    }
}