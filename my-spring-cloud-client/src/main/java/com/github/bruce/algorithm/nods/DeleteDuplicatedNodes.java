package com.github.bruce.algorithm.nods;

public class DeleteDuplicatedNodes {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode first = head;
            while(head != null) {
                ListNode start = head;
                ListNode prev = head;
                head = head.next;
                while (head != null && head.val == prev.val) {
                    prev = prev.next;
                    head = head.next;
                }
                start.next = head;
            }
            return first;
        }
    }
}
