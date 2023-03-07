package com.aneverse.easy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final int[] nums = {1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1};
    final int target = 11;

    final int[] ints = solution.twoSum(nums, target);
    System.out.println(Arrays.toString(ints));
  }

  private static class Solution {

    public int[] twoSum(int[] nums, int target) {
      final Map<Integer, Integer> valueIndexMap = new LinkedHashMap<>();
      for (int i = 0; i < nums.length; i++) {
        final int number = nums[i];
        final int remainder = target - number;
        if (valueIndexMap.containsKey(remainder)) {
          return new int[]{i, valueIndexMap.get(remainder)};
        }
        valueIndexMap.put(number, i);
      }
      return new int[0];
    }
  }
}
