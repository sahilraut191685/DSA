class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> basket = new HashMap<>();
        int maxFruits = 0;
        int left = 0;

       
        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];
            
            
            basket.put(currentFruit, basket.getOrDefault(currentFruit, 0) + 1);

            
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                
                basket.put(leftFruit, basket.get(leftFruit) - 1);

                
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
               
                left++;
            }
             maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    

    }
}