class Solution {

    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // Array is not rotated
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1) != -1;
        }

        // Target is at pivot
        if (nums[pivot] == target) {
            return true;
        }

        // Decide which half to search
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1) != -1;
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1) != -1;
    }

    static int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    static int findPivot(int[] nums) {

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

            // Handle duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {

                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                if (end > start && nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;

            } 
            // Left side is sorted
            else if (nums[start] < nums[mid] ||
                    (nums[start] == nums[mid] && nums[mid] > nums[end])) {

                start = mid + 1;
            } 
            // Right side is sorted
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}