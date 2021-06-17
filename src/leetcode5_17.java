import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode5_17 {

    public static void main(String[] args) {
        int[] rounds = new int[]{1,3,1,2};
        new leetcode5_17().mostVisited(4,rounds);
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int[] record = new int[n];
        for(int i = 0;i<n-1;i++){
            int x = rounds[i];
            while(x!=rounds[i+1]){
                System.out.println(x);
                record[x-1]++;
                x=(x%n) +1;
            }
        }
        record[rounds[n-1]-1]++;
        int max = Arrays.stream(record).max().getAsInt();
        System.out.println(Arrays.toString(record));
        for (int i = 0; i < n; i++) {
            if(record[i]==max){
                list.add(i);
            }
        }
        return list;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
