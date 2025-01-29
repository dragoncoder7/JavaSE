package LeetCode.LeetCode75.LinkList;

public class leetcode31 {
    public static void main(String[] args) {
        leetcode31 leetcode31 = new leetcode31();
        System.out.println(leetcode31.reverseList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))))));
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
