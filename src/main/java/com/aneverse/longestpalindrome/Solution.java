package com.aneverse.longestpalindrome;

import java.util.Arrays;

//https://leetcode.com/problems/longest-palindromic-substring/
public class Solution {

    public static void main(String[] args) {
        final String string = "babad";
        final String string1 = "cbbd";
        final String string2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        final String result = longestPalindrome(string2);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        final char[] chars = s.toCharArray();

        if (isPalindrome(chars, 0, chars.length - 1)) {
            return s;
        }

        char[] maxPalindrome = new char[0];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (!isPalindrome(chars, i, j)) {
                    continue;
                }
                if (maxPalindrome.length > j - i + 1) {
                    continue;
                }
                maxPalindrome = Arrays.copyOfRange(chars, i, j + 1);
            }
        }
        final StringBuilder stringBuilder = new StringBuilder(maxPalindrome.length);
        for (char c : maxPalindrome) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static boolean isPalindrome(char[] chars, int leftIndex, int rightIndex) {
        if (rightIndex == leftIndex) {
            return true;
        }

        if (rightIndex - leftIndex + 1 == 2) {
            return chars[leftIndex] == chars[rightIndex];
        }

        while (leftIndex < rightIndex) {
            if (chars[leftIndex] != chars[rightIndex]) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
