public class leetcode5_10 {
    public leetcode5_10() {
    }

    public static void main(String[] args) {
        leetcode5_10 l = new leetcode5_10();
//        ListNode x = new ListNode(5);
//        ListNode a = new ListNode(4,x);
//        ListNode b = new ListNode(3, a);
//        ListNode c = new ListNode(2, b);
//        ListNode d = new ListNode(1, c);
        ListNode x = new ListNode(2);
        ListNode d = new ListNode(1,x);
        System.out.println(l.removeNthFromEnd(d,1));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1,head);
        ListNode slow = head;
        ListNode fast = head;
        if(head==null){
            return head;
        }
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            pre = pre.next;
            slow = slow.next;
        }
        pre.next = slow.next;
        if(pre.val==-1){
            return pre.next;
        }
        return head;
    }

        public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head;
        ListNode pre = null;
        ListNode fast = head;
        if(head==null){
            return head;
        }
        for (int i = 0; i < n; i++) {
            if(fast==null){
                return head;
            }
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;

        }
        if(pre == null){
            return slow.next;
        }
        pre.next = slow.next;
        return head;
    }
}
