class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack=new Stack<>();
        Stack<String> stringstack=new Stack<>();
        int number=0;
        String current="";
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                number=number*10+(c-'0');
            }
            else if(c=='['){
                countstack.push(number);
                stringstack.push(current);
                number=0;
                current="";
            }
            else if(c==']'){
                int count=countstack.pop();
                String previous=stringstack.pop();
                StringBuilder temp=new StringBuilder(previous);
                for(int i=0;i<count;i++){
                    temp.append(current);
                }
                current=temp.toString();
            }
            else{
                current+=c;
            }
        }
        return current;
    }
}