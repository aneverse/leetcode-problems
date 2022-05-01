package com.aneverse.inttoroman;

//https://leetcode.com/problems/integer-to-roman/
public class Solution {

    private static final Integer[] ARABIC_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        final int num = 2994;
        final String roman = intToRoman(num);
        System.out.println(roman);
    }

    public static String intToRoman(int num) {
        final StringBuilder ans = new StringBuilder();
        for (int i = 0; num > 0; i++)
            while (num >= ARABIC_NUMBERS[i]) {
                ans.append(ROMAN_NUMBERS[i]);
                num -= ARABIC_NUMBERS[i];
            }
        return ans.toString();
    }
}