class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int left = 0;
        int sum = 0;
        int max = 0;
        int alreadySatisfied = 0;

        for (int right = 0; right < customers.length; right++) {

            if (grumpy[right] == 0) {
                alreadySatisfied += customers[right];
            }

            
            if (grumpy[right] == 1) {
                sum += customers[right];
            }

           
            if (right - left + 1 == minutes) {

                max = Math.max(max, sum);

               
                if (grumpy[left] == 1) {
                    sum -= customers[left];
                }

                left++;
            }
        }

        return alreadySatisfied + max;
    }
}