class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, 0, 0, "", ans);
        return ans;
    }
    void solve(String s, int index, int parts, String ip, List<String> ans) {
        if (parts == 4) {
            if (index == s.length()) {
                ans.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            String part = s.substring(index, i + 1);
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }
            if (Integer.parseInt(part) > 255) {
                break;
            }
            solve(s, i + 1, parts + 1, ip + part + ".", ans);
        }
    }
}