import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {4,3,2,7,8,2,3,1};
////        moveZeroes(nums);
//        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
//        for (Integer i: disappearedNumbers)
//            System.out.println(i);
//        Main main = new Main();
//        ListNode l = new ListNode();
//        int[] i = new int[]{3, 2, 0, -4};
//        ListNode.tailInsert(i, l);
//        boolean result = main.hasCycle(l);
//        System.out.println(result);

    }
    public ListNode getIntersectionNodeThird(ListNode headA, ListNode headB) {
        if (headA == null) return null;
        if (headB == null) return null;
        ListNode ListA = headA;
        ListNode ListB = headB;
        while (ListA != ListB){
            ListA = ListA.next == null? headB : ListA.next;
            ListB = ListB.next == null? headA : ListB.next;
        }
        return headA;

    }
    public ListNode getIntersectionNodeSecond(ListNode headA, ListNode headB) {
        if (headA == null) return null;
        if (headB == null) return null;
        ListNode ListA = headA;
        ListNode ListB = headB;
        //
        HashMap<ListNode, ListNode> hashMap = new HashMap<>();
        while (ListA.next != null) {
            hashMap.put(ListA, ListA);
            ListA = ListA.next;
        }
        while (ListB.next != null) {
            if (hashMap.containsValue(ListB))
                return ListB;

            ListB = ListB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 是否相等 不等 next 等于返回
        if (headA == null) return null;
        if (headB == null) return null;
        ListNode ListA = headA;
        ListNode ListB = headB;
        do {
            if (ListA == ListB)
                return ListA;
            else {
                while (ListB.next != null) {
                    ListB = ListB.next;
                    if (ListA == ListB)
                        return ListA;
                }
            }
            ListB = headB;
            ListA = ListA.next;
        } while (ListA != null);


        return null;
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        HashMap<ListNode, ListNode> hashMap = new HashMap<>();
        while (head.next != null) {
            if (!hashMap.isEmpty() && hashMap.containsValue(head))
                return head;
            else
                hashMap.put(head, head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycleSecond(ListNode head) {
        if (head == null) return null;

        ListNode fastNode = head;
        ListNode lowNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;
            if (fastNode == lowNode) {
                lowNode = head;
                while (fastNode != lowNode) {
                    lowNode = lowNode.next;
                    fastNode = fastNode.next;
                }
                return lowNode;

            }
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        HashMap<ListNode, ListNode> hashMap = new HashMap<>();
        while (head.next != null) {
            if (!hashMap.isEmpty() && hashMap.containsValue(head))
                return true;
            else
                hashMap.put(head, head);
            head = head.next;
        }
        return false;

    }

    public boolean hasCycleSecond(ListNode head) {
        if (head == null) return false;

        ListNode fastNode = head;
        ListNode lowNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;
            if (fastNode == lowNode)
                return true;
        }
        return false;
    }


//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        //创建一个数组 下标对应值
//        List<Integer> result = new ArrayList<>();
//        int length = nums.length;
////        int[] temp = new int[length+1];
//        for (int num : nums) result.set(num,result.get(num)+1);
//        for (int i = 0; i < length; i++)
//            if (result.get(i) == 0 && i !=0)
//                result.add(i);
//        return result;
//    }
//
//    public static void moveZeroes(int[] nums) {
//        int j = 0;
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] != 0)
//                nums[j++] = nums[i];
//        for (int i = j; i < nums.length; i++)
//            nums[i] = 0;
//    }
}
