class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n= nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            
            while(left<right){
                
                int temp=nums[i]+nums[left]+nums[right];
                if (Math.abs(temp - target) < Math.abs(closest - target)) {
                     closest = temp;
                }
                if(temp<target){
                    left++;
                    
                }else if(temp>target){
                    right--;

                }else{
                     return temp;
                }
            }
            
        } return closest;
       
    }
}