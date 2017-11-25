/**
 * Created by qgg on 2017/11/25.
 */
public class LinkedListSolution {

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * return 1->4->3->2->5->NULL.
     * Note:
     * Given m, n satisfy the following condition:
     * 1 ≤ m ≤ n ≤ length of list.
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode originHead = head;
        for (int i = m; i > 1; i--) {
            head = head.next;
        }

        ListNode p = head.next;
        for (int i = n; i - m > 0 && p.next != null; i--) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = head.next;
            head.next = q;
        }
        return originHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        LinkedListSolution solution = new LinkedListSolution();
        ListNode head = new ListNode(0xff8);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        solution.reverseBetween(head, 2, 4);
        while (head.next != null) {
            head = head.next;
            System.out.println(head.val);
        }
    }
}
