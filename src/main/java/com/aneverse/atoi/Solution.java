package com.aneverse.atoi;

//https://leetcode.com/problems/string-to-integer-atoi/
public class Solution {

    public static void main(String[] args) {
        final String string = "+-12";
        final int atoi = myAtoi(string);
        System.out.println(atoi);
    }

    public static int myAtoi(String s) {
        final char[] chars = s.toCharArray();

        long result = 0;
        Integer sign = null;
        for (char character : chars) {
            if (character == ' ' && sign == null) {
                continue;
            }
            if (character == '-' && sign == null) {
                sign = -1;
                continue;
            }
            if (character == '+' && sign == null) {
                sign = 1;
                continue;
            }

            if (isDigit(character)) {
                result = (result * 10) + character - 48;

                if (sign == null) {
                    sign = 1;
                }
                if (result * sign >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result * sign <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                continue;
            }
            break;
        }
        if (sign == null) {
            sign = 1;
        }
        return (int) result * sign;
    }

    private static boolean isDigit(char character) {
        return character >= 48 && character <= 57;
    }
}