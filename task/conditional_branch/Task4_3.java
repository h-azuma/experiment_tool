package conditional_branch;

// AtCoder Beginner Contest 039 - Bを改題
// https://atcoder.jp/contests/abc039/tasks/abc039_c

import java.util.ArrayList;
import java.util.List;

public class Task4_3 {
  public static void main(String[] args) {
    final String day = "sat";
    List<Integer> candidate = new ArrayList<>();

    // 1st is Wednesday
    int start = 1;
    switch (day) {
      case "mon":
        start += 5;
        break;
      case "tue":
        start += 6;
        break;
      case "wed":
        // do nothing
        break;
      case "thu":
        start++;
        break;
      case "fri":
        start += 2;
        break;
      case "sat":
        start += 3;
        break;
      case "sun":
        start += 4;
        break;
    }

    for (int i = start; i <= 31; i += 7) {
      candidate.add(i);
    }
    System.out.println(candidate.get(candidate.size() - 2));
  }
}
