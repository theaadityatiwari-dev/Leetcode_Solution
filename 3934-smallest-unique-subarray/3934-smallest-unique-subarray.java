import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final long BASE = 100003L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] pow = new long[n + 1];
        pow[0] = 1L;
        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * BASE;
        }

        int low = 1, high = n, ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueOfLength(nums, pow, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUniqueOfLength(int[] nums, long[] pow, int len) {
        int n = nums.length;
        long hash = 0L;
        for (int i = 0; i < len; i++) {
            hash = hash * BASE + nums[i];
        }

        Map<Long, Integer> freq = new HashMap<>();
        freq.put(hash, 1);

        long highestPow = pow[len - 1];
        for (int i = len; i < n; i++) {
            long outgoing = nums[i - len] * highestPow;
            hash = (hash - outgoing) * BASE + nums[i];
            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}