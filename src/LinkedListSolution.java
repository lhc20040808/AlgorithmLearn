/**
 * Created by qgg on 2017/11/25.
 */
public class LinkedListSolution {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;
        head.next = swapPairs(cur.next);
        cur.next = head;
        return cur;


//        if (head == null)
//            return head;
//
//        ListNode p = head;
//        ListNode q = null;
//        if (p.next != null ) {
//            q = p.next;
//            p.next = q.next;
//            q.next = p;
//            head = q;
//        }
//
//        ListNode pre = null;
//        while (p.next != null && p.next.next != null) {
//            pre = p;
//            p = p.next;
//            q = p.next;
//            p.next = q.next;
//            q.next = p;
//            pre.next = q;
//        }
//        return head;
    }

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
        ListNode tmp = head;
        for (int i = m; i > 1; i--) {
            tmp = tmp.next;
        }
        ListNode p = tmp;
        for (int i = n; i - m > 0 && p.next != null; i--) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = tmp;
            tmp = q;
        }

        if (m == 1) {
            return tmp;
        } else {
            ListNode temp = head;
            for (int i = m; i > 2; i--) {
                temp = temp.next;
            }
            temp.next = tmp;

        }


        for (int i = m; i > 1; i--) {
            head = head.next;
        }


//        ListNode originHead = head;
//        ListNode p = head.next;
//        for (int i = n; i - m > 0 && p.next != null; i--) {
//            ListNode q = p.next;
//            p.next = q.next;
//            q.next = head.next;
//            head.next = q;
//        }
//        return originHead;

        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        reverseBetweenTest();
        swapPairsTest();
    }

    private static void swapPairsTest() {
        LinkedListSolution solution = new LinkedListSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        ListNode head = solution.swapPairs(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static void reverseBetweenTest() {
        LinkedListSolution solution = new LinkedListSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode head = solution.reverseBetween(node1, 2, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
