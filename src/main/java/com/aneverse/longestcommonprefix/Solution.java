package com.aneverse.longestcommonprefix;

//https://leetcode.com/problems/longest-common-prefix/
public class Solution {

    public static void main(String[] args) {
        final String[] strings = {"", "", "", ""};

        final String s = longestCommonPrefix(strings);

        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        final char[][] stringsChars = convertToCharArrays(strs);

        return searchCommonPrefix(stringsChars, 0, new StringBuilder());
    }

    private static String searchCommonPrefix(char[][] arrays, int inIndex, StringBuilder commonPrefix) {
        if (arrays[0].length == 0 || arrays[0].length <= inIndex) {
            return commonPrefix.toString();
        }
        final char currentChar = arrays[0][inIndex];
        boolean allMatch = true;

        for (int i = 0; i < arrays.length; i++) {
            if (inIndex >= arrays[i].length || currentChar != arrays[i][inIndex]) {
                allMatch = false;
                break;
            }
        }

        if (allMatch) {
            commonPrefix.append(currentChar);
            return searchCommonPrefix(arrays, inIndex + 1, commonPrefix);
        }
        return commonPrefix.toString();
    }

    private static char[][] convertToCharArrays(String[] strings) {
        final char[][] result = new char[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            result[i] = strings[i].toCharArray();
        }
        return result;
    }
}