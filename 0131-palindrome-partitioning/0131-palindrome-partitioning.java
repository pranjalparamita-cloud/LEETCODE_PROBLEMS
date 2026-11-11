class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }        
        backtrack(s, 0, dp, currentPath, result);
        return result;
    }
    private void backtrack(String s, int start, boolean[][] dp, List<String> currentPath, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                currentPath.add(s.substring(start, end + 1));
                backtrack(s, end + 1, dp, currentPath, result);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
}