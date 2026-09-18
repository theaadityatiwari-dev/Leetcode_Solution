class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] L = new int[26];
        int[] R = new int[26];
        Arrays.fill(L, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (L[c] == -1) L[c] = i;
            R[c] = i;
        }
        
        List<String> res = new ArrayList<>();
        int right = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (i == L[s.charAt(i) - 'a']) {
                int newRight = getRight(s, i, L, R);
                if (newRight != -1) {
                    if (i > right) {
                        res.add(""); 
                    }
                    right = newRight;
                    res.set(res.size() - 1, s.substring(i, right + 1));
                }
            }
        }
        
        return res;
    }
    
    private int getRight(String s, int i, int[] L, int[] R) {
        int right = R[s.charAt(i) - 'a'];
        for (int j = i; j <= right; j++) {
            if (L[s.charAt(j) - 'a'] < i) return -1;
            right = Math.max(right, R[s.charAt(j) - 'a']);
        }
        return right;
    }
}