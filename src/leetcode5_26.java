import java.util.*;

public class leetcode5_26 {
        int[] result;
        int i = 0;
    public static int[] mostCompetitive(int[] nums, int k) {
        if(result==null){
            result = new int[k];
        }
        int[] split = Arrays.copyOf(nums,nums.length-k+1);
        int min = Arrays.stream(split).min().getAsInt();
        result[i]=min;
        i++;

        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==min){
                index = i;
            }
        }
        if(i<=k){
            mostCompetitive(Arrays.copyOfRange(nums,index+1,nums.length),k-1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,5,2,6};
        mostCompetitive(ints,2);
//        leetcode5_26 l = new leetcode5_26();
//        int[] h = new int[]{2,1,5,6,2,3};
//        int a = l.largestRectangleArea(h);
//        System.out.println(a);
    }

    int max = 0;

    public int largestRectangleArea(int[] heights) {
        int min = Arrays.stream(heights).min().getAsInt();
        max = Math.max(max, min * heights.length);
        if(heights.length>1){
            List<int[]> l = splitArray(heights, min);
            for (int[] ints : l) {
                largestRectangleArea(ints);
            }
        }
        return max;
    }

    public List<int[]> splitArray(int[] array, int num) {
        List<int[]> lists = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (Integer i : array) {
            sb.append(i).append(" ");
        }
        String[] ss = sb.toString().split(String.valueOf(num));

        for (String s : ss) {
            String[] ints = s.trim().split(" ");
            int[] d = new int[ints.length];
            for(int i = 0;i<ints.length;i++){
                if(ints[i].trim().equals("")){
                    continue;
                }
                d[i] = Integer.parseInt(ints[i].strip());
            }
            lists.add(d);
        }
        return lists;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            root = root.right;
            flatten(root.right);
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;

            TreeNode pre = left;
            while (pre.right != null) {
                pre = pre.right;
            }

            root.left = null;
            root.right = left;
            pre.right = right;

            flatten(root.right);
        }

    }


    Queue<TreeNode> queue;

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        queue = new LinkedList<>();
        inQueue(root);
        System.out.println(queue);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            cur.left = null;
            cur.right = queue.peek();
        }
    }

    public void inQueue(TreeNode node) {
        if (node != null) {
            queue.offer(node);
            inQueue(node.left);
            inQueue(node.right);
        }
    }
}
