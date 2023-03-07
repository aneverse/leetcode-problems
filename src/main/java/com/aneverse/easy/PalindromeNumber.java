package com.aneverse.easy;

//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    int x = 11;

//        System.out.println((2L << 31 - 1) - 1);
//        System.out.println(Long.toBinaryString(10L));
//        System.out.println(Long.toBinaryString(40L));
//        System.out.println(10L << 2);
//        System.out.println("" + x);

    System.out.println(solution.isPalindrome2(x));
  }

  private static class Solution {

    public boolean isPalindrome2(int x) {
      if (x < 0) {
        return false;
      }
      final char[] numberChars = ("" + x).toCharArray();

      if (numberChars.length == 2) {
        return numberChars[0] == numberChars[1];
      }

      int leftIndex = 0;
      int rightIndex = numberChars.length - 1;
      while (leftIndex < rightIndex) {
        if (numberChars[leftIndex] != numberChars[rightIndex]) {
          return false;
        }
        leftIndex++;
        rightIndex--;
      }
      return true;
    }

    public static boolean isPalindrome(int x) {
      if (x < 0) {
        return false;
      }
      final int xLength = getNumberLengthByRepMul(x);

      long mirroredNumber = 0;
      for (int i = 0, j = xLength - 1; i < xLength; i++, j--) {
        final long pow = (long) Math.pow(10, i + 1);
        long digit = x % pow / (pow / 10);
        mirroredNumber += digit * Math.pow(10, j);
      }
      return x == mirroredNumber;
    }

    public static int getNumberLengthByLogarithm(int number) {
      return (int) (Math.log10(number) + 1);
    }

    public static int getNumberLengthByRepMul(int number) {
      int length = 0;
      long temp = 1;
      while (temp <= number) {
        length++;
        temp *= 10;
      }
      return length;
    }
  }
}
