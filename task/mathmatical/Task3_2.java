package mathmatical;

// AtCoder Beginner Contest 006 - Cを改題
// https://atcoder.jp/contests/abc006/tasks/abc006_3

public class Task3_2 {
    public static void main(String[] args) {
        int sum = 10;
        int legs = 36;

        int crane = 0;
        int turtle = sum;

        // crane has 2 legs and turtle has 4 legs
        while (!(2 * crane + 4 * turtle == legs && crane + turtle == sum)) {
            // Reduce turtle number and add crane number
            crane++;
            turtle--;
        }

        System.out.println("crane: " + crane);
        System.out.println("turtle: " + turtle);
    }
}
