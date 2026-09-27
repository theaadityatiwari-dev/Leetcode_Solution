class Solution {
    public String reverseParentheses(String s) {
        StringBuilder current = new StringBuilder();
        java.util.ArrayDeque<StringBuilder> stack = new java.util.ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Save the current progress to the stack and start a new buffer
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                // Reverse the inner string
                current.reverse();
                // Append it to the previous string buffer from the stack
                current = stack.pop().append(current);
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}