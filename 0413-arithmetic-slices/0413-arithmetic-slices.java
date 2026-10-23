class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int left = 0;
        int count = 0;
        int sum = 0;
        if(nums.length<3){
            return 0;
        }
        for (int right = 2; right < nums.length; right++) {

             if (nums[right] - nums[right - 1] !=
                nums[right - 1] - nums[right - 2]) {

                left = right - 1;
            }

            count += right - left - 1;
        }
        return count;
    }
}