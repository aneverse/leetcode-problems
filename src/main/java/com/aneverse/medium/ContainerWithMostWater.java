package com.aneverse.medium;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    final int area = solution.maxArea(heights);
    System.out.println(area);
  }

  private static class Solution {

    private int maxArea(int[] height) {
      int result = 0;
      int left = 0;
      int right = height.length - 1;
      while (left < right) {
        int currentArea = Math.min(height[left], height[right]) * (right - left);
        result = Math.max(result, currentArea);

        if (height[left] < height[right]) {
          left++;
        } else {
          right--;
        }
      }
      return result;
    }
  }
}
