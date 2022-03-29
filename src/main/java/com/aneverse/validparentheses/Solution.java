package com.aneverse.validparentheses;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class Solution {

    public static void main(String[] args) {
        final String string = "((({{{[[[}}]]])))))";

        System.out.println(isValid(string));
    }

    public static boolean isValid(String s) {
        final char[] chars = s.toCharArray();
        final Stack<Character> characterStack = new Stack<>();

        for (char character : chars) {
            if (character == '(' || character == '{' || character == '[') {
                characterStack.push(character);
                continue;
            }
            if (characterStack.isEmpty()) {
                return false;
            }
            if (character == ')' && characterStack.peek() == '(') {
                characterStack.pop();
                continue;
            }
            if (character == '}' && characterStack.peek() == '{') {
                characterStack.pop();
                continue;
            }
            if (character == ']' && characterStack.peek() == '[') {
                characterStack.pop();
                continue;
            }

            return false;
        }
        return characterStack.isEmpty();
    }
}