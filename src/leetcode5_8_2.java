
import java.util.*;

public class leetcode5_8_2 {
    int[] result;

    public static void main(String[] args) {
        leetcode5_8_2 l = new leetcode5_8_2();
//        int[][] graph = new int[][]{{4, 9}, {3, 5, 7}, {0, 3, 4, 5, 6, 8}, {7, 8, 9}, {5, 6, 7, 8}, {6, 7, 8, 9}, {7, 9}, {8, 9}, {9}, {}};
        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5},{},{}};
        System.out.println(l.eventualSafeNodes(graph));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (search(graph, i, color)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean search(int[][] graph, int n, int[] color) {
        if (color[n] > 0) {
            return color[n] == 2;
        }
        color[n] = 1;
        for (Integer i : graph[n]) {
            if (color[n] == 2)
                continue;
            if (color[i] == 1 || !search(graph, i, color))
                return false;
        }
        color[n]=2;
        return true;
    }
}
