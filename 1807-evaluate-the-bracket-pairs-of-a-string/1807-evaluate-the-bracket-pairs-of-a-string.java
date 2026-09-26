class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> entry : knowledge) {
            dict.put(entry.get(0), entry.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') {
                int j = s.indexOf(')', i + 1);
                String key = s.substring(i + 1, j);
                sb.append(dict.getOrDefault(key, "?"));
                i = j + 1;
            } else {
                sb.append(ch);
                i++;
            }
        }

        return sb.toString();
    }
}