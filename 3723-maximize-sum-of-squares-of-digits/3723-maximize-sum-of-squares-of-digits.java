class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        while (sum > 0) {
            int digit = Math.min(9, sum);
            result.append(digit);
            sum -= digit;
        }

        while (result.length() < num) {
            result.append('0');
        }

        return result.toString();
    }
}