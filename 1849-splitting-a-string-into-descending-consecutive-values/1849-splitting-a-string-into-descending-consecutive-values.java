import java.math.BigInteger;
class Solution {
    public boolean splitString(String s) {
        return solve(s, 0, null, 0);
    }
    boolean solve(String s, int index, BigInteger prev, int parts) {
        if (index == s.length()) {
            return parts >= 2;
        }
        BigInteger num = BigInteger.ZERO;
        for (int i = index; i < s.length(); i++) {
            num = num.multiply(BigInteger.TEN)
                     .add(BigInteger.valueOf(s.charAt(i) - '0'));
            if (prev == null || num.equals(prev.subtract(BigInteger.ONE))) {
                if (solve(s, i + 1, num, parts + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}