class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count > 0) {
                    result += '(';
                }
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
                if (count > 0) {
                    result += ')';
                }
                
            }
        }
        return result;

    }
}