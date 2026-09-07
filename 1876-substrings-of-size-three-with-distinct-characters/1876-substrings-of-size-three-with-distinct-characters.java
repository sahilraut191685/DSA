class Solution {
    public int countGoodSubstrings(String s) {
       int left=0; 
       int count=0;
       for(int right=0;right<s.length();right++){
        if(right-left+1==3){
            
            if(s.charAt(left)!=s.charAt(right)&&s.charAt(left+1)!=s.charAt(right)&&s.charAt(left)!=s.charAt(left+1)){
               count++;
            
            }
            left++;
        }
       } 
       return count;
    }
}