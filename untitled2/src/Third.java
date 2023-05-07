import java.util.HashMap;
import java.util.List;

public class Third {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode.tailInsert(new int[]{1, 2, 3}, l);
        ListNode.list(l);
        ListNode kthFromEnd = getKthFromEnd(l, 1);
        System.out.println(kthFromEnd.val);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        head = head.next;
        if (head == null) return null;
        ListNode fastNode = head;
        ListNode lowNode = head;
        int i = 0;
        while (fastNode != null && fastNode.next != null) {
            if (fastNode.next.next != null){
                i++;
                lowNode = lowNode.next;
            }

            fastNode = fastNode.next.next;

        }
        int l = i;
        for (; i < (2 * l+1) + 1 - k; i++) {
            lowNode = lowNode.next;
        }
        return lowNode;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode fastNode = head;
        ListNode lowNode = head;
        while (fastNode != null && fastNode.next != null) {
            lowNode = lowNode.next;
            fastNode = fastNode.next.next;
        }

        return lowNode;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode fastNode = head;
        ListNode lowNode = head;
        while (fastNode != null) {
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;

        }
        ListNode listNode = reverseList(lowNode);
        ListNode node = head;
        while (listNode != null) {
            if (listNode != node) return false;
            listNode = listNode.next;
            node = node.next;
        }
        return true;
    }

    public boolean isPalindromeSecond(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        ListNode t = head;
        while (head != null) {

            if (preNode != head) return false;
            preNode = preNode.next;
            head = head.next;
        }
        return true;

    }

}
