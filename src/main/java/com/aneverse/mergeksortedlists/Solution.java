package com.aneverse.mergeksortedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class Solution {

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

    public static void main(String[] args) {
        final ListNode first = new ListNode(1, new ListNode(4, new ListNode(5)));
        final ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        final ListNode third = new ListNode(2, new ListNode(6));
        final ListNode[] lists = {null};
        final ListNode node = mergeKLists(lists);
        System.out.println(node);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
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
