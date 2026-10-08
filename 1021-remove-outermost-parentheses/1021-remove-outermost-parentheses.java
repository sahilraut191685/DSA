class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count++;

                if (count == 1) {
                    s = s.substring(0, i) + s.substring(i + 1);
                    i--;
                }
            }

            else {
                count--;

                if (count == 0) {
                    s = s.substring(0, i) + s.substring(i + 1);
                    i--;
                }
            }
        }

        return s;
    }
}