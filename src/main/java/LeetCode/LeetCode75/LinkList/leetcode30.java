package LeetCode.LeetCode75.LinkList;

import java.util.List;

public class leetcode30 {
    public static void main(String[] args) {
        leetcode30 leetcode30 = new leetcode30();
        System.out.println();
    }
    public ListNode oddEvenList(ListNode head) {
        ListNode node2 = head.next;

        ListNode odd = head;
        ListNode even = node2;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = node2;
        return head;
    }
}
