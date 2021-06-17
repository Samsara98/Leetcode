public class leetcode5_8 {


    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(1, a);
        ListNode c = new ListNode(2, b);
        ListNode d = new ListNode(4, c);
        leetcode5_8 leet = new leetcode5_8();
        ListNode result= leet.sortList(d);
        System.out.println(result);
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!= null&& fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return merge(head,slow);
    }
    public ListNode merge(ListNode h1,ListNode h2){
        ListNode h = h2.next;
        h2.next = null;
        h2 = h;
        h1 = sortList(h1);
        h2 = sortList(h2);
        ListNode head = null;
        ListNode cur = null;
        while (h1!=null || h2 != null){
            int v1 = h1==null?Integer.MAX_VALUE:h1.val;
            int v2 = h2==null?Integer.MAX_VALUE:h2.val;
            if (v1 <= v2) {
                if (head == null) {
                    head = h1;
                    cur = head;
                }else {
                    cur.next = h1;
                    cur = h1;
                }
                h1 = h1.next;
            } else {
                if (head == null) {
                    head = h2;
                    cur = head;
                }else {
                    cur.next = h2;
                    cur = h2;
                }
                h2 = h2.next;
            }
        }
        return head;
    }
}

