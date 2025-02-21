package LeetCode.LeetCode75.LinkList;

public class leetcode32 {
    public static void main(String[] args) {
        leetcode32 leetcode32 = new leetcode32();
        ListNode listNode = new ListNode(4,new ListNode(2,new ListNode(2,new ListNode(3))));
        System.out.println(leetcode32.pairSum2(listNode));
    }
    public int pairSum(ListNode head) {
        int res = Integer.MIN_VALUE;
        int length = length(head);
        int[] ints = new int[length];
        int i = 0;
        while (head != null){
            ints[i] = head.val;
            head = head.next;
            i++;
        }
        int left = 0, right = length - 1;
        while (left < right){
            int sum = ints[left] + ints[right];
            res = Math.max(sum, res);
            left++;
            right--;
        }
        return res;
    }

    public int length(ListNode root){
        int length = 0;
        if (root != null ){
            length++;
            while (root.next != null){
                length++;
                root = root.next;
            }
        }
        return length;
    }

    public int pairSum1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 只有2个节点
        if (slow.next == null) {
            return head.val + head.next.val;
        }

        ListNode head2 = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = next;
        }

        int result = 0;
        while (head2 != null) {
            result = Math.max(head.val + head2.val, result);
            head = head.next;
            head2 = head2.next;
        }

        return result;
    }


    public int pairSum2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // // 只有2个节点
        // if (slow.next == null) {
        //     return head.val + head.next.val;
        // }

        ListNode head2 = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = next;
        }

        int result = 0;
        while (head2 != null) {
            result = Math.max(head.val + head2.val, result);
            head = head.next;
            head2 = head2.next;
        }

        return result;
    }
}
