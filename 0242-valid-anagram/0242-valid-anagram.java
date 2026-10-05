class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> oyo=new HashMap<>();
        for(char c:s.toCharArray()){
            oyo.put(c,oyo.getOrDefault(c,0)+1);

        }
        for(char x:t.toCharArray()){
            if (!oyo.containsKey(x)) {
                return false;
            }
            oyo.put(x, oyo.get(x) - 1);
            if (oyo.get(x) == 0) {
                oyo.remove(x);
            }
        }
        return oyo.isEmpty();
    }
}