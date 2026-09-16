class Solution {
    public int[] decrypt(int[] code, int k) {
      
        int n = code.length;
        int[] result = new int[n];
        
        // 1. The Guard: If k is 0, return the array of zeros immediately
        if (k == 0) {
            return result;
        }
        
        // 2. The Setup: Determine where the first window starts and ends
        int start = k > 0 ? 1 : n + k;
        int end = k > 0 ? k : n - 1;
        
        // Calculate the sum of this initial window manually
        int windowSum = 0;
        for (int i = start; i <= end; i++) {
            windowSum += code[i % n]; // % n keeps us safe if indices wrap around
        }
        
        // 3. The Slide: Walk through the array and update the sums in O(1) time
        for (int i = 0; i < n; i++) {
            // Save the current window's sum for the current index i
            result[i] = windowSum;
            
            // Slide the window 1 step forward:
            // Subtract the element that is leaving from the left
            windowSum -= code[start % n];
            
            // Move both pointers forward
            start++;
            end++;
            
            // Add the new element that is entering from the right
            windowSum += code[end % n];
        }
        
        return result;
    }
}

