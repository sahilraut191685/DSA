class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int maxDiff = 0;
        long total = 0;

        for (int i = 0; i < diff.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            total += diff[i];
        }
        Arrays.sort(diff);
        int start = 0;
        int end = maxDiff;

        if (total <= k) {
            return 0;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            long operations = 0;

            for (int d : diff) {
                operations += Math.max(0, d - mid);
            }

            if (operations <= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        long answer = 0;
        long operationsUsed = 0;

        for (int d : diff) {
            int reduced = Math.min(d, start);
            operationsUsed += d - reduced;
            answer += (long) reduced * reduced;
        }

        long remaining = k - operationsUsed;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] >= start && start > 0) {
                answer -= (long) start * start;
                answer += (long) (start - 1) * (start - 1);
                remaining--;
            }
        }

        return answer;

    }
}