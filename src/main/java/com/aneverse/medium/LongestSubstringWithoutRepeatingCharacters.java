package com.aneverse.medium;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final String string = "dvdf";
    final String string1 = "abcabcbb";
    final String string2 = "pwwkew";
    final String string3 = "ckilbkd";
    final String string4 = "bbbbb";
    final int result = solution.lengthOfLongestSubstring(string4);
    System.out.println(result);
  }

  private static class Solution {

    public int lengthOfLongestSubstring(String s) {
      if (s.length() == 1) {
        return 1;
      }
      Set<Character> alreadyViewed = new HashSet<>();
      final char[] chars = s.toCharArray();
      int maxCounter = 0;
      for (int i = 0, j = 0, charsLength = chars.length; i < charsLength; i++) {
        if (!alreadyViewed.contains(chars[i])) {
          alreadyViewed.add(chars[i]);
        } else {
          maxCounter = Math.max(maxCounter, alreadyViewed.size());
          alreadyViewed = new HashSet<>();
          j = i - 1;
          while (chars[j] != chars[i] && j > 0) {
            alreadyViewed.add(chars[j--]);
          }
          i--;
        }
      }
      return Math.max(alreadyViewed.size(), maxCounter);
    }
  }
}
