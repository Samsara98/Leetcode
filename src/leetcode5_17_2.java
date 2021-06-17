import java.util.Arrays;

public class leetcode5_17_2 {
    public static void main(String[] args) {
        leetcode5_17_2.checkInclusion("ab", "abcdef");
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++a1[s1.charAt(i) - 'a'];
            ++a2[s2.charAt(i) - 'a'];
        }
        for (int i = n; i < m; i++) {
            if (Arrays.equals(a1, a2)) {
                return true;
            }
            --a2[s2.charAt(i-n)-'a'];
            ++a2[s2.charAt(i)-'a'];
        }
        return false;
    }
}
