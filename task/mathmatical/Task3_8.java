package mathmatical;

// AtCoder Beginner Contest 042 - Cを改題
// https://atcoder.jp/contests/abc042/tasks/arc058_a

public class Task3_8 {
  public static void main(String[] args) {
    final int start = 5000;
    final int[] badNumbers = {0, 1, 2, 3, 5, 7, 8};

    int answer = start;
    int tmp = 0;
    boolean isContainBadNumbers;

    outside:
    while (true) {
      for (int i = 3; i >= 0; i--) {
        isContainBadNumbers = false;
        int digit = (int) Math.pow(10.0, (double) i);

        if (digit != 1000) {
          for (int cut = 1000; cut > digit; cut /= 10) {
            tmp = answer % cut;
          }
        } else {
          tmp = answer;
        }
        for (int x = 0; x < badNumbers.length; x++) {
          if (tmp / digit == badNumbers[x]) {
            isContainBadNumbers = true;
            break;
          }
        }
        // isContainBadNumber is method that check whether "answer" contains badNumbers or not
        if (isContainBadNumbers) {
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
}
