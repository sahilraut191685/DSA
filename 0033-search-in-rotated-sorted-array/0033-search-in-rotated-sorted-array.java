class Solution {
    public int search(int[] nums, int target) {
        int peak = peakelement(nums);

        // Array is not rotated
        if (peak == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // Peak element is the target
        if (nums[peak] == target) {
            return peak;
        }

        // Search in first half
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, peak - 1);
        }

        // Search in second half
        return binarySearch(nums, target, peak + 1, nums.length - 1);
    }

    // Find pivot (largest element)
    static int peakelement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Case 2
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // Search left
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            }
            // Search right
            else {
                start = mid + 1;
            }
        }

        return -1; // Array is not rotated
    }

    // Normal Binary Search
    static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}