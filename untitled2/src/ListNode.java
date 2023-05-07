import java.util.List;
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode() {
        this.next = null;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        int[] i = new int[]{3, 2, 0, -4};
        tailInsert(i, l);
        list(l);
    }

    public static void headInsert(int[] list, ListNode l) {

        for (int i : list) {
            ListNode r = new ListNode(i);
            if (l.next != null)
                r.next = l.next;
            l.next = r;

        }

    }

    public static void tailInsert(int[] list, ListNode l) {
        ListNode r;
        r = Objects.requireNonNullElse(l.next, l);
        for (int i : list) {
            r.next = new ListNode(i);
            r = r.next;
        }

    }

    public static void list(ListNode l) {
        while (l != null) {
            System.out.println(l.val);
            l = l.next;

        }
    }

}