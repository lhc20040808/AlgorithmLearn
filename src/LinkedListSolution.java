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


        return head;
    }


    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1;
        ListNode q = l2;
        int add = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (p != null || q != null) {
            int num1 = (p != null) ? p.val : 0;
            int num2 = (q != null) ? q.val : 0;
            int sum = num1 + num2 + add;
            add = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }


            if (add > 0) {
                cur.next = new ListNode(add);
            }

        }

        return head.next;
//        return addTwoNumbers(l1, l2, 0);
    }

    /**
     * Remove all elements from a linked list of integers that have value val.
     * Example
     * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     * Return: 1 --> 2 --> 3 --> 4 --> 5
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmpHead = new ListNode(0);
        ListNode prev = tmpHead;
        tmpHead.next = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return tmpHead.next;
    }

    /**
     * 82.Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode prev = tmpHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                continue;
            }

            if (prev.next == curr) {
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return tmpHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {

        if (l1 == null && l2 == null && add == 0) {
            return null;
        }

        ListNode l1Next;
        int num1;
        if (l1 == null) {
            l1Next = null;
            num1 = 0;
        } else {
            l1Next = l1.next;
            num1 = l1.val;
        }

        ListNode l2Next;
        int num2;
        if (l2 == null) {
            l2Next = null;
            num2 = 0;
        } else {
            l2Next = l2.next;
            num2 = l2.val;
        }


        int sum = num1 + num2 + add;
        if (sum >= 10) {
            add = 1;
            sum = sum - 10;
        } else {
            add = 0;
        }
        ListNode node = new ListNode(sum);
        node.next = addTwoNumbers(l1Next, l2Next, add);
        return node;
    }

    /**
     * 19.Given a linked list, remove the nth node from the end of list and return its head.
     * For example,
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode first = tmpHead;
        ListNode second = tmpHead;

        for (int i = 0; i <= n; i++) {
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return tmpHead.next;
    }

    /**
     * 61.Given a list, rotate the list to the right by k places, where k is non-negative.
     * Example:
     * Given 1->2->3->4->5->NULL and k = 2,
     * return 4->5->1->2->3->NULL.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode fastNode = tmpHead;
        ListNode slowNode = tmpHead;


        int i;
        for (i = 0; fastNode.next != null; i++) {
            fastNode = fastNode.next;
        }

        for (int j = i - k % i; j > 0; j--) {
            slowNode = slowNode.next;
        }

        fastNode.next = tmpHead.next;
        tmpHead.next = slowNode.next;
        slowNode.next = null;

        return tmpHead.next;
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
//        swapPairsTest();
//        addTwoNumbersTest();
//        removeElementsTest();
        rotateRightTest();
    }

    private static void removeElementsTest() {
        LinkedListSolution solution = new LinkedListSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        ListNode head = solution.removeElements(node1, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
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

    private static void addTwoNumbersTest() {
//        ListNode a1 = new ListNode(2);
//        ListNode a2 = new ListNode(4);
//        ListNode a3 = new ListNode(3);
//        a1.next = a2;
//        a2.next = a3;

//        ListNode b1 = new ListNode(5);
//        ListNode b2 = new ListNode(6);
//        ListNode b3 = new ListNode(4);
//        b1.next = b2;
//        b2.next = b3;

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode b1 = new ListNode(0);

        a1.next = a2;

        LinkedListSolution solution = new LinkedListSolution();
        ListNode head = solution.addTwoNumbers(a1, b1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static void rotateRightTest() {
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


        ListNode head = solution.rotateRight(null, 0);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
