class Solution {
    public long maxAlternatingSum(int[] nums) {
       int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(sq);

        int k = n / 2;          
        long score = 0;

        for (int i = 0; i < k; i++) {
            score -= sq[i];    
        }
        for (int i = k; i < n; i++) {
            score += sq[i];    
        }
        return score;
    }
}