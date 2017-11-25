
public class ArraySolution {
    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * <p>
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] != 0) {
                if (start != end) {
                    int tmp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = tmp;
                }
                start++;
            }
            end++;
        }
    }

    /**
     * Given an array and a value, remove all instances of that value in-place and return the new length.
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * Example:
     * Given nums = [3,2,2,3], val = 3,
     * Your function should return length = 2, with the first two elements of nums being 2.
     */
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] != val) {
                if (start != end) {
                    int tmp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = tmp;
                }
                start++;
            }
            end++;
        }
        return start;
    }

    /**
     * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * Example:
     * Given nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     * It doesn't matter what you leave beyond the new length.
     */
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] == nums[start]) {
                end++;
                continue;
            }
            nums[++start] = nums[end];
        }

        return start + 1;
    }

    /**
     * What if duplicates are allowed at most twice?
     * For example,
     * Given sorted array nums = [1,1,1,2,2,3],
     * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
     */
    public int removeDuplicates2(int[] nums) {
        final int dupCount = 2;
        int i = 0;
        for (int n : nums) {
            if (i < dupCount || n > nums[i - dupCount]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     */
    public int[] twoSum(int[] numbers, int target) {
        int indexLox = 0;
        int indexHigh = numbers.length - 1;
        while (indexLox < indexHigh) {
            if (numbers[indexLox] + numbers[indexHigh] > target) {
                indexHigh--;
            } else if (numbers[indexLox] + numbers[indexHigh] < target) {
                indexLox++;
            } else {
                break;
            }
        }
        return new int[]{indexLox + 1, indexHigh + 1};
    }

    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * Note: You may not slant the container and n is at least 2.
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area;
        while (left < right) {

            if (height[left] < height[right]) {
                area = height[left] * (right - left);
            } else {
                area = height[right] * (right - left);
            }

            if (area > maxArea) {
                maxArea = area;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    /**
     * Given an array with n objects colored red, white or blue,
     * sort them so that objects of the same color are adjacent,
     * with the colors in the order red, white and blue.
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     */
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }

        int left = start;
        int right = end;
        while (left != right) {

            while (nums[right] > nums[start] && left < right) {
                right--;
            }

            while (nums[left] <= nums[start] && left < right) {
                left++;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }

        int tmp = nums[start];
        nums[start] = nums[left];
        nums[left] = tmp;
        quickSort(nums, start, left - 1);
        quickSort(nums, right + 1, end);
    }

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * For example,
     * Given [3,2,1,5,6,4] and k = 2, return 5.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     */
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
//        moveZeroesTest();
//        removeElementTest();
//        removeDuplicatesTest();
//        removeDuplicates2Test();
//        twoSumTest();
//        maxAreaTest();
//        sortColorsTest();
        findKthLargestTest();
    }

    private static void removeDuplicatesTest() {
        ArraySolution arraySolution = new ArraySolution();
        int[] nums = {1, 2, 2, 3, 3, 4, 5, 5, 6};
        int length = arraySolution.removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void removeDuplicates2Test() {
        ArraySolution arraySolution = new ArraySolution();
//        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 6};
//        int[] nums = {1, 2, 2, 2, 3, 3, 4, 4};
//        int[] nums = {1, 1, 1, 2, 2, 2, 3};
//        int[] nums = {1, 1, 1, 2, 3, 3};
        int[] nums = {1, 2, 2, 2, 3};
        int length = arraySolution.removeDuplicates2(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void moveZeroesTest() {
        ArraySolution arraySolution = new ArraySolution();
        int[] nums = {5, 4, 1, 7, 3, 0, 12, 2, 0};
        arraySolution.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void removeElementTest() {
        ArraySolution arraySolution = new ArraySolution();
        int[] nums = {3, 2, 2, 3};
        int length = arraySolution.removeElement(nums, 3);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void twoSumTest() {
        ArraySolution arraySolution = new ArraySolution();
        int[] nums = {1, 2, 4, 5, 6, 15};
        int[] result = arraySolution.twoSum(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static void maxAreaTest() {
        ArraySolution arraySolution = new ArraySolution();
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 7, 3};
        int area = arraySolution.maxArea(nums);
        System.out.print("面积:" + area);
    }

    private static void sortColorsTest() {
        ArraySolution arraySolution = new ArraySolution();
//        int[] nums = {1, 2, 0, 1, 2, 0, 1, 2, 0};
        int[] nums = {0, 2, 1};
        arraySolution.sortColors(nums);
    }

    private static void findKthLargestTest() {
        ArraySolution arraySolution = new ArraySolution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 1;
        int result = arraySolution.findKthLargest(nums, k);
        System.out.println("第" + k + "个最大值" + result);
    }

}
