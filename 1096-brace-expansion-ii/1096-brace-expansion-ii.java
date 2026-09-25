import java.util.*;

class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        index = 0;
        Set<String> set = parseExpression(expression);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    private Set<String> parseExpression(String expr) {
        Set<String> result = new HashSet<>();
        while (index < expr.length() && expr.charAt(index) != '}') {
            result.addAll(parseTerm(expr));
            if (index < expr.length() && expr.charAt(index) == ',') {
                index++;
            }
        }
        return result;
    }

    private Set<String> parseTerm(String expr) {
        Set<String> current = new HashSet<>();
        current.add("");

        while (index < expr.length() && expr.charAt(index) != '}' && expr.charAt(index) != ',') {
            Set<String> nextFactor = parseFactor(expr);
            current = cartesianProduct(current, nextFactor);
        }
        return current;
    }

    private Set<String> parseFactor(String expr) {
        char ch = expr.charAt(index);
        if (ch == '{') {
            index++;
            Set<String> inner = parseExpression(expr);
            index++;
            return inner;
        } else {
            Set<String> single = new HashSet<>();
            single.add(String.valueOf(ch));
            index++;
            return single;
        }
    }

    private Set<String> cartesianProduct(Set<String> set1, Set<String> set2) {
        Set<String> product = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                product.add(s1 + s2);
            }
        }
        return product;
    }
}