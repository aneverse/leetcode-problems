package com.aneverse.medium;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    System.out.println(solution.reverse(123));
    System.out.println(solution.reverse(-123));
    System.out.println(solution.reverse(120));
    System.out.println(solution.reverse(-2147483648));
  }

  private static class Solution {

    public int reverse(int x) {
      int number = x < 0 ? -x : x;
      int numberLength = getNumberLength(number);
      int result = 0;
      while (numberLength > 0) {
        int remainder = number % 10;
        result += remainder * Math.pow(10, numberLength - 1);
        if (result == Integer.MAX_VALUE) {
          return 0;
        }
        numberLength--;
        number /= 10;
      }
      return x < 0 ? -result : result;
    }

    private static int getNumberLength(int number) {
      int counter = 0;
      while (number > 0) {
        number = number / 10;
        counter++;
      }
      return counter;
    }
  }
}
