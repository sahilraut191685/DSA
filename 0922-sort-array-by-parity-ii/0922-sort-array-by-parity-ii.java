class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n= nums.length;
        int left=0;
        int right=1;
        while(left<n && right<n){
            if(left<n && nums[left]%2==0){
                left+=2;

            } if(right<n && nums[right]%2==1){
                right+=2;
            }
            if(left<n && right<n && nums[left] % 2 == 1 && nums[right] % 2 == 0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;

                left+=2;
                right+=2;
            }
        }
        return nums;
    }
}