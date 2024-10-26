package LeetCode.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution43 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */ 
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 基础 链表相加1
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + add;
            if (head == null){
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            add = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add != 0){
            tail.next = new ListNode(0);
        }
        //判断最后的进位是不是1 是的话 再加一个节点
        return head;
    }

    /**
     * 进阶 链表相加2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = null, tail;
        Deque<Integer> dequeL1 = new ArrayDeque<>();
        Deque<Integer> dequeL2 = new ArrayDeque<>();
        while (l1 != null){
            dequeL1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            dequeL2.push(l2.val);
            l2 = l2.next;
        }

        while (!dequeL1.isEmpty() || !dequeL2.isEmpty() || add != 0){
            int a = dequeL1.isEmpty() ? 0 : dequeL1.pop();
            int b = dequeL2.isEmpty() ? 0 : dequeL2.pop();
            int sum = a + b + add;
            ListNode node = new ListNode(sum % 10);
            add = sum / 10;
            node.next = head;
            head = node;
        }
        return head;
    }
}
