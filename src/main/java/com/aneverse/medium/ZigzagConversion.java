package com.aneverse.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    String string = "PAYPALISHIRING";
    String string1 = "0123456789";
    int numWords = 6;
    System.out.println(solution.convert(string1, numWords));
  }

  private static class Solution {

    public String convert(String s, int numRows) {
      if (s.length() < 2 || numRows == 1) {
        return s;
      }
      final char[] chars = s.toCharArray();
      final List<Character>[] result = new ArrayList[numRows];
      for (int i = 0; i < numRows; i++) {
        result[i] = new ArrayList<>(chars.length);
      }
      boolean isDiagonalMoving = false;
      for (int i = 0, row = 0; i < chars.length; i++) {
        result[row].add(chars[i]);
        if (isDiagonalMoving && row - 1 == -1) {
          isDiagonalMoving = false;
        }
        if (row + 1 < numRows && !isDiagonalMoving) {
          row++;
        } else {
          row--;
          isDiagonalMoving = true;
        }
      }
      final StringBuilder resultBuilder = new StringBuilder(s.length());
      for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[i].size(); j++) {
          if (result[i].get(j) != ' ') {
            resultBuilder.append(result[i].get(j));
          }
        }
      }
      return resultBuilder.toString();
    }
  }
}
