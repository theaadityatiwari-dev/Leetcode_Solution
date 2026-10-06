class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int unmatchedClose = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
            } else {
                
                if (openCount > 0) {
                    openCount--;
                } else {
                   
                    unmatchedClose++;
                }
            }
        }

        return unmatchedClose + openCount;
    }
}