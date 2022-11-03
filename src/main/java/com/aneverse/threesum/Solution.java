package com.aneverse.threesum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

//https://leetcode.com/problems/3sum/
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        final List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        final Map<Integer, Set<Integer>> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final Set<Integer> indexes = numbers.computeIfAbsent(nums[i], t -> new HashSet<>());
            indexes.add(i);
        }

        final Set<List<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int ijSum = nums[i] + nums[j];
                final Set<Integer> indexes = numbers.get(-ijSum);
                if (indexes != null && ((!indexes.contains(i) && !indexes.contains(j)) || i != j && indexes.size() >= 3)) {
                    final List<Integer> triplet = Stream.of(nums[i], nums[j], -ijSum)
                            .sorted()
                            .toList();
                    triplets.add(triplet);
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return new ArrayList<>(triplets);
    }
}
