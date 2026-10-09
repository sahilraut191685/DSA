
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If the next character is ')', consume the pair together.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Only one ')' available; insert another ')'.
                    insertions++;
                }

                // This '))' pair needs one unmatched '('.
                if (open > 0) {
                    open--;
                } else {
                    // No '(' available, so insert one '('.
                    insertions++;
                }
            }
        }

        // Each remaining '(' needs two closing parentheses.
        insertions += open * 2;

        return insertions;
    }
}
