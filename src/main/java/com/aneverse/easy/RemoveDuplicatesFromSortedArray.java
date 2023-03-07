package com.aneverse.easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final int[] nums = {1, 1};

    final int i = solution.removeDuplicates(nums);
    System.out.println(i);
  }

  private static class Solution {

    public int removeDuplicates(int[] nums) {
      int counter = 0;
      for (int i = 0, lastI = -1; i < nums.length; i++) {
        final int currentNumber = nums[i];
        counter++;
        if (i + 1 < nums.length && nums[i + 1] == currentNumber) {
          i--;
          do {
            nums[++i] = 101;
          } while (i + 1 < nums.length && nums[i + 1] == currentNumber);
        } else {
          nums[i] = 101;
        }
        nums[++lastI] = currentNumber;
      }
      return counter;
    }
  }
}
