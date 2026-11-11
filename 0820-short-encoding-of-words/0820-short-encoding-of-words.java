class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set=new HashSet<>(Arrays.asList(words));
        for(String str:words){
            for(int i=1;i<str.length();i++){
                set.remove(str.substring(i));
            }
        }
        int ans=0;
        for(String w:set){
            ans+=w.length()+1;
        }
        return ans;
    }
}