import java.util.Arrays;

public class leetcode5_8_3 {

    public static void main(String[] args) {
        leetcode5_8_3 l = new leetcode5_8_3();
        System.out.println(Arrays.toString(l.countBits(5)));
    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num == 0) {
            return result;
        }
        result[1] = 1;
        int a = 1;
        for (int i = 2; i < num + 1; i++) {
            if ((i & (i - 1)) == 0) {
                result[i] = 1;
                a=a*2;
                continue;
            }
            result[i] = result[i - a] + result[a];
        }
        return result;
    }
}
