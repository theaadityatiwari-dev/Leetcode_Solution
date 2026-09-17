class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;

        int[] best = new int[n];
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        long sum = 0;
        int ans = INF;
        int minLen = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left++];
            }

            // If current subarray has sum = target
            if (sum == target) {
                int len = right - left + 1;

                
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                
                minLen = Math.min(minLen, len);
            }

            
            best[right] = minLen;
        }

        return ans == INF ? -1 : ans;
    }
}