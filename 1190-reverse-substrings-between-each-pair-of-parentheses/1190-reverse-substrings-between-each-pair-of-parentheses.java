class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ')') {
                int i = sb.length() - 1;
                while (i >= 0 && sb.charAt(i) != '(') {
                    i--;
                }
                
                String part = sb.substring(i + 1);
                sb.delete(i, sb.length());
                sb.append(new StringBuilder(part).reverse());
            } else if (c != '(') {
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString().replace("(", "").replace(")", "");
    }
}