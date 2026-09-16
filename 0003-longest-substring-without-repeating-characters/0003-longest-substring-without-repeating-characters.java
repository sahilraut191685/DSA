class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left=0;
        int length=0;
        int max=0;

        if(s.length()==1){
            return 1;
        }
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                
                set.remove(s.charAt(left));
                left++;
               
            }

            length=right-left+1;
            set.add(s.charAt(right));
            max=Math.max(length, max);
            


        }
        return  max;
    }
}