public class leetcode5_12 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return p == null;
        }
        if(p.val != q.val){
            return false;
        }else {
            boolean left = isSameTree(p.left,q.left);
            if(!left){
                return false;
            }
            boolean right = isSameTree(p.right,q.right);
            if(!right){
                return false;
            }
        }
        return true;
    }

}
