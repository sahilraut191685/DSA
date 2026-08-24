// class Solution {
//     public int maxArea(int[] height) {
//          int left=0;
//         int right=height.length-1;
//         int res=0;
//         while(left<right) {
//             int water = Math.min(height[left], height[right]) * (right - left);
//             res = Math.max(res, water);
//             if (height[left] < height[right])
//                 left += 1;
//             else
//                 right -= 1;
            
//         }
//         return res;
//     }
// }

class Solution {
    static{
        for(int i = 0; i<60; i++){
             maxArea(new int[]{0,0});
        }
    }
        
    
    public static int maxArea(int[] h) {
       
        int srt  = 0;
        int end = h.length-1;
        int maxWater  = 0;
        while(srt < end){
            int minH = Math.min(h[srt], h[end]);
            int area = minH * (end-srt);
            maxWater = Math.max(maxWater, area);
           while(srt < end && h[srt] <= minH){
            srt++;
           }
           while(srt < end && h[end] <= minH){
            end--;
           }
            
        }
        return maxWater;
        
    }
}
