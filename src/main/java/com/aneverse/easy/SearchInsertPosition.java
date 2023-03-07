package com.aneverse.easy;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final int[] nums = {1, 3, 5, 6};
    final int target1 = 5;
    final int target2 = 2;
    final int target3 = 7;

    final int result1 = solution.searchInsert(nums, target1);
    final int result2 = solution.searchInsert(nums, target2);
    final int result3 = solution.searchInsert(nums, target3);

    assert result1 == 2;
    assert result2 == 1;
    assert result3 == 4;
  }

  private static class Solution {
    public int searchInsert(int[] nums, int target) {
      return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] array, int left, int right, int target) {
      if (left > right) {
        return left;
      }

      final int middle = (left + right) / 2;
      if (target == array[middle]) {
        return middle;
      } else if (array[middle] > target) {
        return binarySearch(array, left, middle - 1, target);
      }
      return binarySearch(array, middle + 1, right, target);
    }
  }
}
