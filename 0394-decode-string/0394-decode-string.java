class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String current = "";
        int number = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            else if (c == '[') {
                countStack.push(number);
                stringStack.push(current);
                number = 0;
                current = "";
            }
            else if (c == ']') {
                int count = countStack.pop();
                String previous = stringStack.pop();
                StringBuilder temp = new StringBuilder(previous);
                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }
                current = temp.toString();
            }
            else {
                current += c;
            }
        }
        return current;
    }
}