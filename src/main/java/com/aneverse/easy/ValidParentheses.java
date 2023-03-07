package com.aneverse.easy;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final String string = "((({{{[[[}}]]])))))";

    System.out.println(solution.isValid(string));
  }

  private static class Solution {

    public boolean isValid(String s) {
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
}
