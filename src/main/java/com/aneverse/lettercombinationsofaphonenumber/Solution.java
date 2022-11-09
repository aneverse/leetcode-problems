package com.aneverse.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Solution {

    public static void main(String[] args) {
        final String digits = "678";
        final List<String> strings = letterCombinations(digits);
        System.out.println(strings.size());
        System.out.println(strings);
    }

    private static final Map<Character, char[]> phoneKeyboard;

    static {
        phoneKeyboard = new HashMap<>();
        phoneKeyboard.put('2', new char[]{'a', 'b', 'c'});
        phoneKeyboard.put('3', new char[]{'d', 'e', 'f'});
        phoneKeyboard.put('4', new char[]{'g', 'h', 'i'});
        phoneKeyboard.put('5', new char[]{'j', 'k', 'l'});
        phoneKeyboard.put('6', new char[]{'m', 'n', 'o'});
        phoneKeyboard.put('7', new char[]{'p', 'q', 'r', 's'});
        phoneKeyboard.put('8', new char[]{'t', 'u', 'v'});
        phoneKeyboard.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {
        final List<String> combinations = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return combinations;
        }
        combine(digits.toCharArray(), 0, "", combinations);

        return combinations;
    }

    private static void combine(char[] digits, int index, String combination, List<String> combinations) {
        if (index == digits.length) {
            if (!combination.isEmpty()) {
                combinations.add(combination);
            }
            return;
        }
        final char[] s = phoneKeyboard.get(digits[index]);
        for (int i = 0; i < s.length; i++) {
            combine(digits, index + 1, combination + s[i], combinations);
        }
    }
}
