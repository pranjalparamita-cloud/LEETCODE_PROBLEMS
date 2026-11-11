class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        String[] parts=path.split("/");
        for(String part:parts){
            if(part.equals("")||part.equals(".")){
                continue;
            }
            if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                    stack.push(part);
            }
        }
        String result="";
        for(String dir:stack){
            result+="/";
            result+=dir;
        }
        return result.length()==0?"/":result;
    }
}