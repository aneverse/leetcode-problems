package com.aneverse.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final Solution.ListNode first = new Solution.ListNode(1, new Solution.ListNode(4, new Solution.ListNode(5)));
    final Solution.ListNode second = new Solution.ListNode(1, new Solution.ListNode(3, new Solution.ListNode(4)));
    final Solution.ListNode third = new Solution.ListNode(2, new Solution.ListNode(6));
    final Solution.ListNode[] lists = {null};
    final Solution.ListNode node = solution.mergeKLists(lists);
    System.out.println(node);
  }

  private static class Solution {

    public static class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
        this.val = val;
      }

      ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
      }

      @Override
      public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
      }
    }

    public ListNode mergeKLists(ListNode[] lists) {
      final List<ListNode> listNodes = new ArrayList<>(Arrays.stream(lists).filter(Objects::nonNull).toList());

      final ListNode head = new ListNode();

      if (!listNodes.isEmpty()) {
        recursiveMerge(head, listNodes);
        return head.next;
      }
      return null;
    }

    private static void recursiveMerge(ListNode head, List<ListNode> lists) {
      if (lists.isEmpty()) {
        return;
      }
      int smallestValueIndex = lists.size() - 1;
      int smallestValue = lists.get(smallestValueIndex).val;
      for (int i = 0; i < lists.size(); i++) {
        if (smallestValue > lists.get(i).val) {
          smallestValue = lists.get(i).val;
          smallestValueIndex = i;
        }
      }
      final ListNode node = lists.get(smallestValueIndex);
      head.next = node;
      if (node.next == null) {
        lists.remove(smallestValueIndex);
      } else {
        lists.set(smallestValueIndex, node.next);
      }
      recursiveMerge(head.next, lists);
    }
  }
}
