class Solution {
    public boolean check(int[] nums) {

       int head=0;
       int tail=1;
       int x=-1;

        while(tail<nums.length){
            if(nums[head]>nums[tail]){
                x=head;
                break;
            }
            head++;
            tail++;
        }
       

       //  make it sorted
       int[] num = new int[nums.length];
       for(int i = 0; i < num.length; i++){
        num[i]=nums[(i+x+1)%nums.length];
        
       }
       // find the sorted array
       int head1=0;
       int tail1=1;
        while(tail1<num.length){
            if(num[head1]>num[tail1]){
                return false;
            }
            head1++;
            tail1++;
        }
        return true;
    }
}