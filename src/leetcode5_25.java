import java.util.Arrays;

public class leetcode5_25 {

    public static void main(String[] args) {
//        System.out.println(numTrees(3));
        System.out.println(Math.pow(6,13));
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] mark : queries) {
            int a = 0;
            for (int[] point : points) {
                if (Math.pow(Math.abs(mark[0] - point[0]), 2) + Math.pow(Math.abs(mark[1] - point[1]), 2) <= Math.pow(mark[2],2)) {
                    a++;
                }
            }
            answer[index] = a;
            index++;
        }
        return answer;
    }

    public static int numTrees(int n) {

        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                System.out.println(i + "-" + j + "-" + (i - j - 1));
                ints[i] += (ints[j] * ints[i - j - 1]);
            }
            System.out.println("*");
        }
        System.out.println(Arrays.toString(ints));
        return ints[n];
    }
}
