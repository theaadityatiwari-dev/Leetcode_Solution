class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long total = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long k = (long) k1 + k2;

        if (total <= k) {
            return 0;
        }

        int left = 0, right = maxDiff;

        
        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int limit = left;
        long used = 0;

        
        for (int i = 0; i < n; i++) {
            if (diff[i] > limit) {
                used += diff[i] - limit;
                diff[i] = limit;
            }
        }

        long remaining = k - used;

        
        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == limit && limit > 0) {
                diff[i]--;
                remaining--;
            }
        }

       
        long result = 0;

        for (int d : diff) {
            result += (long) d * d;
        }

        return result;
    }
}