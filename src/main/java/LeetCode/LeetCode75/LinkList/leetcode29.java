package LeetCode.LeetCode75.LinkList;

import java.util.List;

public class leetcode29 {
    public static void main(String[] args) {
        leetcode29 leetcode29 = new leetcode29();
        //System.out.println(leetcode29.length(new ListNode(2,new ListNode(1))));
        System.out.println(leetcode29.deleteMiddle(new ListNode(1)));
    }
    public ListNode deleteMiddle(ListNode head) {
        int length = length(head);
        if (length <= 1){
            return null;
        }
        getListNode(head,(length / 2) - 1).next = getListNode(head,(length / 2)).next;
        return head;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */


     public int length(ListNode listNode){
         int length = 0;
         while (listNode!= null){
             length++;
             listNode = listNode.next;
         }
         return length;
     }

     public ListNode getListNode(ListNode listNode, int i){
         if (length(listNode) < i){
             return null;
         }
         for (int j = 0; j < i; j++) {
             listNode = listNode.next;
         }
         return listNode;
     }

    /**
     * 快慢指针 双倍 快指针遍历完了 慢指针正好指向中间节点。
     * @param head ListNode节点
     * @return
     */
    public ListNode deleteMiddle1(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
