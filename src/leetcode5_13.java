import java.util.Arrays;

public class leetcode5_13 {

    public static void main(String[] args) {
        TreeNode right = new TreeNode(-3);
        TreeNode root = new TreeNode(-2, null, right);
        leetcode5_13 l = new leetcode5_13();
        int p = 509;
        double A = Math.pow(5, 12);
        System.out.println(A % p);
        double B = Math.pow(5, 34);
        System.out.println(B % p);
        double b = Math.pow(5, 34);
        System.out.println(b % 509);
    }

    public int smallestRangeI(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        return max - min + 2 * k;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (targetSum == root.val && root.left == null && root.right == null) {
            return true;
        }
        TreeNode cur = root;
        boolean le = false;
        boolean ri = false;
        if (cur.left != null) {
            System.out.println(cur.left.val + "-" + (targetSum - cur.val));
            le = hasPathSum(cur.left, targetSum - cur.val);
        }
        if (cur.right != null) {
            System.out.println(cur.right.val + "-" + (targetSum - cur.val));
            ri = hasPathSum(cur.right, targetSum - cur.val);
        }
        return le || ri;
    }

}
