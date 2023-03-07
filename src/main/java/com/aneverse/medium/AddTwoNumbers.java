package com.aneverse.medium;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

  public static void main(String[] args) {
    final Solution solution = new Solution();

    final Solution.ListNode listNode1 = new Solution.ListNode(9, new Solution.ListNode(9, new Solution.ListNode(9, new Solution.ListNode(9))));
    final Solution.ListNode listNode2 = new Solution.ListNode(8, new Solution.ListNode(7, new Solution.ListNode(7)));
    final Solution.ListNode listNode = solution.addTwoNumbersAtOneStep(listNode1, listNode2);
    System.out.println(listNode.toString());
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

    public ListNode addTwoNumbersAtOneStep(ListNode l1, ListNode l2) {
      return buildNode(l1, l2, 0);
    }

    public static ListNode buildNode(ListNode l1, ListNode l2, int remainder) {
      if (l1 == null && l2 == null && remainder == 0) {
        return null;
      }
      final int firstNumber = l1 == null ? 0 : l1.val;
      final int secondNumber = l2 == null ? 0 : l2.val;
      int sumNumber = firstNumber + secondNumber + remainder;
      remainder = 0;

      if (sumNumber > 9) {
        remainder = 1;
        sumNumber = sumNumber % 10;
      }
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
      return new ListNode(sumNumber, buildNode(l1, l2, remainder));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      final int[] firstNumber = buildNumber(l1);
      final int[] secondNumber = buildNumber(l2);
      final int[] sum = sumNumbers(firstNumber, secondNumber);
      return decomposeNumber(sum, 0, null);
    }


    private static ListNode decomposeNumber(int[] number, int numberLength, ListNode node) {
      if (numberLength == number.length) {
        return node;
      }

      final ListNode newNode = new ListNode(number[numberLength], node);
      return decomposeNumber(number, numberLength + 1, newNode);
    }

    private static int[] buildNumber(ListNode listNode) {
      final int[] array = new int[findNumberLength(listNode)];
      return buildNumber(listNode, array.length - 1, array);
    }

    private static int[] buildNumber(ListNode node, int index, int[] array) {
      array[index] = node.val;
      return node.next == null ? array : buildNumber(node.next, index - 1, array);
    }

    private static int[] sumNumbers(int[] first, int[] second) {
      int[] result = new int[Math.max(first.length, second.length)];
      int firstIndex = first.length - 1;
      int secondIndex = second.length - 1;
      int resultIndex = result.length - 1;

      int remainder = 0;
      while (true) {
        int firstNumber = firstIndex < 0 ? 0 : first[firstIndex];
        int secondNumber = secondIndex < 0 ? 0 : second[secondIndex];
        int sumNumber = firstNumber + secondNumber + remainder;

        if (remainder != 0) {
          remainder = 0;
        }

        if (sumNumber > 9) {
          remainder = 1;
          result[resultIndex--] = sumNumber % 10;
        } else {
          result[resultIndex--] = sumNumber;
        }
        firstIndex--;
        secondIndex--;

        if (firstIndex < 0 && secondIndex < 0 && remainder == 0) {
          break;
        } else if (resultIndex < 0 && remainder != 0) {
          resultIndex = 0;
          int[] newArray = new int[result.length + 1];
          System.arraycopy(result, 0, newArray, 1, result.length);
          result = newArray;
        }
      }
      return result;
    }

    private static int findNumberLength(ListNode listNode) {
      return listNode.next == null ? 1 : findNumberLength(listNode.next) + 1;
    }


    /*public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final BigInteger result = buildNumber(l1, 0).add(buildNumber(l2, 0));
        final int numberLength = result.toString().length();
        if (numberLength == 1) {
            return new ListNode(result.intValue());
        }
        return decomposeNumberAndReverse(result, numberLength, null);
    }

    private static ListNode decomposeNumberAndReverse(BigInteger number, int length, ListNode previous) {
        if (number.compareTo(BigInteger.ZERO) == 0 && length == 0) {
            return previous;
        }
        final BigInteger tenInLengthPow = BigInteger.TEN.pow(length - 1);
        final BigInteger value = number.divide(tenInLengthPow);
        final ListNode newNode = new ListNode(value.intValue(), previous);
        number = number.mod(tenInLengthPow);
        return decomposeNumberAndReverse(number, length - 1, newNode);
    }

    private static BigInteger buildNumber(ListNode listNode, int currentDimension) {
        final BigInteger factor = BigInteger.valueOf(10).pow(currentDimension);
        final BigInteger number = BigInteger.valueOf(listNode.val).multiply(factor);
        return listNode.next == null
                ? number
                : buildNumber(listNode.next, currentDimension + 1).add(number);
    }*/
  }
}
