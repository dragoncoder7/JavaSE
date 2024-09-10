package LeetCode.Solution;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Solution38 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        // 获取当前时间的 ZonedDateTime 对象，使用系统默认时区
        ZonedDateTime now = ZonedDateTime.now();

        // 将时间格式化为 ISO 8601 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

        String formattedDate = now.format(formatter);
        // 输出结果
        System.out.println(formattedDate);
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

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//    }
    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
