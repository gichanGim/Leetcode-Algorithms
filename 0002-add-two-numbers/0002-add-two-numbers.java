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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
            ListNode cur = result;

            ListNode node1 = l1;
            ListNode node2 = l2;

            int plus1 = 0;

            while (node1 != null || node2 != null) {
                int i1 = node1 == null ? 0 : node1.val;
                int i2 = node2 == null ? 0 : node2.val;

                int sum = i1 + i2 + plus1;

                if (sum >= 10) {
                    sum = sum - 10;
                    plus1 = 1;
                }
                else
                    plus1 = 0;

                cur.next = new ListNode(sum);
                cur = cur.next;

                if (node1 != null) node1 = node1.next;
                if (node2 != null) node2 = node2.next;
            }

            if (plus1 == 1) {
                cur.next = new ListNode(1);
            }

            return result.next;
    }
}