import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

public class leetcode4_30 {

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
            leetcode4_30.ListNode cur = this;
            while (cur != null) {
                System.out.println(cur.val);
                cur = cur.next;
            }
            return "*";
        }
    }

    public static void main(String[] args) {
        leetcode4_30 l = new leetcode4_30();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1, a);
//        ListNode c = new ListNode(3, b);
//        ListNode d = new ListNode(2, c);
//        ListNode e = new ListNode(1, d);
        System.out.println(l.reverseKGroup(b,2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        List<ListNode> list = reverse(head, k);
        ListNode pre = head;
        head = list.get(0);
        ListNode nf = list.get(1);
        while (nf != null) {
            list = reverse(nf, k);
            if (pre.next != null) {
                pre.next = list.get(0);
            }
            pre = nf;
            nf = list.get(1);
        }
        return head;

    }

    public List<ListNode> reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        List<ListNode> x = new ArrayList<>();

        ListNode test = head;
        for (int i = 0; i < k-1; i++) {
            test = test.next;
            if(test == null){
                x.add(head);
                x.add(null);
                return x;
            }
        }
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = cur;
        x.add(pre);
        x.add(cur);
        return x;
    }
}
