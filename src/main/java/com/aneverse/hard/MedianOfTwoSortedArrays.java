package com.aneverse.hard;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final int[] nums1 = {1, 3};
    final int[] nums2 = {2};

    final double result = solution.findMedianSortedArrays(nums1, nums2);
    System.out.println(result);
  }

  private static class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      final int[] mergedArray = mergeArrays(nums1, nums2);
      final int arrayMiddleIndex = mergedArray.length / 2;
      return mergedArray.length % 2 != 0
          ? mergedArray[arrayMiddleIndex]
          : (mergedArray[arrayMiddleIndex] + mergedArray[arrayMiddleIndex - 1]) / 2.0;
    }

    private static int[] mergeArrays(int[] nums1, int[] nums2) {
      final int[] result = new int[nums1.length + nums2.length];
      for (int r = 0, n1 = 0, n2 = 0; r < result.length; r++) {
        final Integer firstValue = n1 < nums1.length ? nums1[n1] : null;
        final Integer secondValue = n2 < nums2.length ? nums2[n2] : null;

        if (firstValue != null && secondValue != null) {
          if (firstValue >= secondValue) {
            result[r] = secondValue;
            n2++;
          } else {
            result[r] = firstValue;
            n1++;
          }
        } else {
          if (firstValue == null && secondValue != null) {
            result[r] = secondValue;
            n2++;
          } else if (firstValue != null) {
            result[r] = firstValue;
            n1++;
          }
        }
      }
      return result;
    }
  }
}
