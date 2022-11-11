package com.aneverse.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

//https://leetcode.com/problems/4sum/
public class Solution {

    public static void main(String[] args) {
        final int[] nums = {-1000000000, -1000000000, 1000000000, -1000000000, -1000000000};
        final int target = 294967296;
        final List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        final List<Integer> numbers = Arrays.stream(nums).sorted().boxed().toList();
        final Set<List<Integer>> quadruplets = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    final int sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    if ((numbers.get(i) > 0 && numbers.get(j) > 0 && numbers.get(k) > 0 && sum < 0)
                            || (numbers.get(i) < 0 && numbers.get(j) < 0 && numbers.get(k) < 0 && sum > 0)) {
                        continue;
                    }

                    final int fourthNum = target - sum;
                    final int fourthNumIndex = Collections.binarySearch(numbers, fourthNum);
                    if (fourthNumIndex < 0 || fourthNumIndex == i || fourthNumIndex == j || fourthNumIndex == k) {
                        continue;
                    }
                    final List<Integer> quadruplet = Stream.of(numbers.get(i), numbers.get(j), numbers.get(k), fourthNum)
                            .sorted()
                            .toList();
                    quadruplets.add(quadruplet);
                }
            }
        }
        return new ArrayList<>(quadruplets);
    }
}
