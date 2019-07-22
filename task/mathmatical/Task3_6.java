package mathmatical;

// AtCoder Beginner Contest 042 - Cを改題
// https://atcoder.jp/contests/abc042/tasks/arc058_a

public class Task3_6 {
    public static void main(String[] args) {
        int start = 5000;
        int[] badNumber = {0, 1, 2, 3, 5, 7, 8};
        int answer = start;

        outside:
        while (true) {
            for (int i = 3; i >= 0; i--) {
                int digit = (int) Math.pow(10.0, (double) i);

                // isContainBadNumber is method that check whether "answer" contains badNumber or not
                if (isContainBadNumber(badNumber, answer, digit)) {
                    answer += digit;
                    break;
                }
                if (i == 0) {
                    // break while
                    break outside;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isContainBadNumber(int[] badNumber, int num, int digit) {
        if (digit != 1000) {
            for (int cut = 1000; cut > digit; cut /= 10) {
                num %= cut;
            }
        }
        for (int bn : badNumber) {
            if (num / digit == bn) {
                return true;
            }
        }
        return false;
    }
}
