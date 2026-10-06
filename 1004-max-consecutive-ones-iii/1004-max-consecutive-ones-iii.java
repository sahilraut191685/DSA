class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int length=0;
        int count=0;
        int max=0;
        for(int right=0;right<nums.length;right++){
           
            if(nums[right]==0){
                count++;
            }
            while(count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            if(count<=k){
                length=right-left+1;
            }
            max=Math.max(max,length);

        }
        return max;
    }
}