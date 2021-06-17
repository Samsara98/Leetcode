import java.util.Arrays;

public class leetcode5_19 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n <= 0) {
            return null;
        }
        int sp=0;
        for (int i = 0; i < n; i++) {
            if(inorder[i] ==preorder[0]){
                sp = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree((arraySplit(preorder,1,sp)),(arraySplit(inorder,0,sp-1)));
        root.right = buildTree((arraySplit(preorder,sp+1,n-1)),(arraySplit(inorder,sp+1,n-1)));
        return root;
    }

    public int[] arraySplit(int[] array,int s,int e){
        int[] result = new int[e-s+1];
        if (e + 1 - s >= 0) System.arraycopy(array, s, result, 0, e + 1 - s);
        return result;
    }
}
