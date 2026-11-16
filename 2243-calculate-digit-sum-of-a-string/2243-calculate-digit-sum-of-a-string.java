class Solution {
    public String digitSum(String s, int k) {
        // Repeat the process until the length of the string is no longer greater than k
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            
            // Process the string in chunks of size k
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                // Sum up digits in the current group
                for (int j = i; j < Math.min(s.length(), i + k); ++j) {
                    sum += s.charAt(j) - '0';
                }
                // Append the sum string to our builder
                sb.append(sum);
            }
            
            // Update s with the newly formed string
            s = sb.toString();
        }
        
        return s;
    }
}