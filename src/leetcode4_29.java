public class leetcode4_29 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode cur = this;
            while (cur != null) {
                System.out.println(cur.val);
                cur = cur.next;
            }
            return "*";
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(1, b);
        ListNode d = new ListNode(1, c);
        leetcode4_29 x = new leetcode4_29();
        System.out.println(x.isPalindrome(d));
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode one = head;
        ListNode two = head;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        ListNode pre = null;
        ListNode cur = one;
        ListNode nex = one.next;
        while (true) {
            cur.next = pre;
            pre = cur;
            cur = nex;
            if (cur == null) {
                break;
            }
            nex = nex.next;
        }
        System.out.println(pre);
        System.out.println(head);
        ListNode a = head;
        ListNode b = pre;
        while (b != null) {
            if (a.val == b.val) {
                a = a.next;
                b = b.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
