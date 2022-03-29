package com.aneverse.romantoint;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/
public class Solution {

    public static void main(String[] args) {
        final String roman = "DCXXI";

        System.out.println(romanToInt(roman));
    }

    public static int romanToInt(String s) {
        final char[] romanChars = s.toCharArray();

        final Map<Character, Integer> digitsMappings = prepareMappings();

        return convertRecursive(romanChars, 0, 0, digitsMappings);
    }

    private static int convertRecursive(char[] chars, int index, int number, Map<Character, Integer> mappings) {
        if (index >= chars.length) {
            return number;
        }

        final char currentChar = chars[index];

        if (index + 1 < chars.length) {
            if (currentChar == 'I') {
                final char nextChar = chars[index + 1];
                if (nextChar == 'V' || nextChar == 'X') {
                    number += mappings.get(nextChar) - mappings.get(currentChar);
                    return convertRecursive(chars, index + 2, number, mappings);
                }
            } else if (currentChar == 'X') {
                final char nextChar = chars[index + 1];
                if (nextChar == 'L' || nextChar == 'C') {
                    number += mappings.get(nextChar) - mappings.get(currentChar);
                    return convertRecursive(chars, index + 2, number, mappings);
                }
            } else if (currentChar == 'C') {
                final char nextChar = chars[index + 1];
                if (nextChar == 'D' || nextChar == 'M') {
                    number += mappings.get(nextChar) - mappings.get(currentChar);
                    return convertRecursive(chars, index + 2, number, mappings);
                }
            }
        }

        number += mappings.get(currentChar);
        return convertRecursive(chars, index + 1, number, mappings);
    }

    private static Map<Character, Integer> prepareMappings() {
        final Map<Character, Integer> mappings = new HashMap<>();
        mappings.put('I', 1);
        mappings.put('V', 5);
        mappings.put('X', 10);
        mappings.put('L', 50);
        mappings.put('C', 100);
        mappings.put('D', 500);
        mappings.put('M', 1000);

        return mappings;
    }
}