class Solution {
    public boolean uniformArray(int[] nums1) {
       
       int left=0;
       int right=nums1.length-1;
       int[] nums2 = new int[nums1.length];
       while(left<right){
       if(nums1[left]%2==0){ 
        nums2[left]=nums1[left];
        }
        else if(nums1[right]%2==1){
            nums2[right]=nums1[right];
        }

        left++;
        right--;
       }

     return Arrays.stream(nums2).allMatch(num -> num % 2 == 0 || num % 2 == 1);
    }
}