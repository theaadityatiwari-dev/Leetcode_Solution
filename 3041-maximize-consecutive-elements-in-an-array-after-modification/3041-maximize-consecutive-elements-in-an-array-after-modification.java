import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : nums) {
            int inc = dp.getOrDefault(x, 0) + 1;
            dp.put(x + 1, inc);
            ans = Math.max(ans, inc);

            int keep = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, Math.max(dp.getOrDefault(x, 0), keep));
            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}