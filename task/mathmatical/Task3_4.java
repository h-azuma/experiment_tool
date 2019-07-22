package mathmatical;

// AtCoder Beginner Contest 030 - Bを改題
// https://atcoder.jp/contests/abc030/tasks/abc030_b

public class Task3_4 {
    public static void main(String[] args) {
        // consider clock
        int shortHand = 15;
        int longHand = 17;

        // (6.0 / 0.5) is the angle (long / short) hand exceed per 1min.
        double longHandAngle = (double) longHand * 6.0;
        double shortHandAngle = (double) (shortHand % 12) * 30.0 + (double) (longHand) * 0.5;

        if (shortHandAngle >= longHandAngle) {
            System.out.println(shortHandAngle - longHandAngle);
        } else {
            System.out.println(longHandAngle - shortHandAngle);
        }
    }
}
