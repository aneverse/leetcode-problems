package com.aneverse.easy;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final Solution.ListNode list1 = new Solution.ListNode(1, new Solution.ListNode(2, new Solution.ListNode(4)));
    final Solution.ListNode list2 = new Solution.ListNode(1, new Solution.ListNode(3, new Solution.ListNode(4)));

    //final ListNode list1 = new ListNode(5);
    //final ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(4)));

    Solution.ListNode listNode = solution.mergeTwoLists(list1, list2);

    while (listNode != null) {
      System.out.print(listNode.val + " ");
      if (listNode.next == null) {
        break;
      }
      listNode = listNode.next;
    }
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      final ListNode tempNode = new ListNode(0);
      ListNode tailNode = tempNode;
      while (true) {
        if (list1 == null) {
          tailNode.next = list2;
          break;
        }
        if (list2 == null) {
          tailNode.next = list1;
          break;
        }
        if (list1.val <= list2.val) {
          tailNode.next = list1;
          list1 = list1.next;
        } else {
          tailNode.next = list2;
          list2 = list2.next;
        }
        tailNode = tailNode.next;
      }
      return tempNode.next;
    }
  }
}
