package com.aneverse.removeduplicates;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class Solution {

    public static void main(String[] args) {
        final int[] nums = {1, 1};

        final int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int counter = 0;
        for (int i = 0, lastI = -1; i < nums.length; i++) {
            final int currentNumber = nums[i];
            counter++;
            if (i + 1 < nums.length && nums[i + 1] == currentNumber) {
                i--;
                do {
                    nums[++i] = 101;
                } while (i + 1 < nums.length && nums[i + 1] == currentNumber);
            } else {
                nums[i] = 101;
            }
            nums[++lastI] = currentNumber;
        }
        return counter;
    }
}