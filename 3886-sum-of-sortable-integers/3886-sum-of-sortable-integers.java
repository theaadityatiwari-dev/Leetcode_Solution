import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int totalSum = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean possible = true;
            for (int i = 0; i < n; i += k) {
                int dropCount = 0;
                int dropIdx = -1;

                for (int j = 0; j < k - 1; j++) {
                    if (nums[i + j] > nums[i + j + 1]) {
                        dropCount++;
                        dropIdx = j;
                    }
                }

                if (dropCount > 1) {
                    possible = false;
                    break;
                }

                if (dropCount == 1 && nums[i + k - 1] > nums[i]) {
                    possible = false;
                    break;
                }

                int offset = (dropCount == 1) ? dropIdx + 1 : 0;
                for (int j = 0; j < k; j++) {
                    if (nums[i + (offset + j) % k] != sorted[i + j]) {
                        possible = false;
                        break;
                    }
                }

                if (!possible) break;
            }

            if (possible) {
                totalSum += k;
            }
        }

        return totalSum;
    }
}