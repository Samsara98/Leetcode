import java.util.Arrays;

public class leetcode5_24 {

    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1,1, 100000}, 2.01));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > hour + 1) {
            return -1;
        }
        int n = dist.length;
        long min = (int) Math.ceil(Arrays.stream(dist).sum() / hour);
        long max = Math.round(Math.max(Arrays.stream(Arrays.copyOfRange(dist, 0, n - 1)).max().getAsInt(), dist[n - 1] / (hour - n + 1)));
        while (max - min > 1) {
            double mid = (max + min) / 2.0;
            double h = getH(dist, n, mid);
            if (h > hour) {
                min = (long) Math.floor(mid);
            } else {
                max = (long) Math.ceil(mid);
            }
        }
        double minHour = getH(dist, n, min);
        if (minHour <= hour) {
            return (int) min;
        } else {
            return (int) max;
        }
    }

    private static double getH(int[] dist, int n, double mid) {
        double h = 0;
        for (int i = 0; i < n - 1; i++) {
            h += Math.ceil(dist[i] / mid);
        }
        h += (double) dist[n - 1] / mid;
        return h;
    }
}
