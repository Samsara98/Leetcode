import java.util.ArrayList;
import java.util.List;

public class leetcode6_1 {


    List<Integer> rightView;

    public List<Integer> rightSideView(TreeNode root) {
        TreeNode cur = root;
        rightView = new ArrayList<>();
        rightView.add(root.val);
        addNum(root, 2);
        return rightView;
    }

    public void addNum(TreeNode node, int num) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            if (rightView.size() == num-1) {
                rightView.add(node.right.val);
            }
            addNum(node.right, num + 1);
        }
        if (node.left != null) {
            if (rightView.size() == num-1) {
                rightView.add(node.left.val);
            }
            addNum(node.left, num + 1);
        }
    }
}
