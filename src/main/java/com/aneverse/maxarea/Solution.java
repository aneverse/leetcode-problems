package com.aneverse.maxarea;

//https://leetcode.com/problems/container-with-most-water/
public class Solution {

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        final int area = maxArea(heights);
        System.out.println(area);
    }

    private static int maxArea(int[] height) {
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
