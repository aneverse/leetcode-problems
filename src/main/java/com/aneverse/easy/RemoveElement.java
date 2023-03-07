package com.aneverse.easy;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final int[] nums = {3, 2, 2, 3};
    final int val = 3;

    System.out.println(solution.removeElement1(nums, val));
  }

  private static class Solution {

    public int removeElement1(int[] nums, int val) {
      int element = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
          nums[element] = nums[i];
          element++;
        }
      }
      return element;
    }

    //тупое условие задачи, возможно решение проще
    public static int removeElement(int[] nums, int val) {
      final int REMOVED_NUMBER_LITERAL = -1;
      int counter = 0;
      for (int i = 0, trueIndex = 0; i < nums.length; i++) {
        if (trueIndex != i && nums[i] != val) {
          nums[trueIndex++] = nums[i];
          nums[i] = REMOVED_NUMBER_LITERAL;
          counter++;
          continue;
        }
        if (nums[i] == val) {
          nums[i] = REMOVED_NUMBER_LITERAL;
          i++;
          while (i + 1 < nums.length && nums[i] == val) {
            nums[i] = REMOVED_NUMBER_LITERAL;
            i++;
          }
          if (i < nums.length) {
            nums[trueIndex++] = nums[i];
            nums[i] = REMOVED_NUMBER_LITERAL;
          }
        } else {
          trueIndex++;
          counter++;
        }
      }
      return counter + 1;
    }
  }
}
