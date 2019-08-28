package conditional_branch;

// AtCoder Beginner Contest 014 - Bを改題
// https://atcoder.jp/contests/abc014/tasks/abc014_2

import java.util.ArrayList;
import java.util.List;

public class Task4_6 {
  public static void main(String[] args) {
    int input = 130211;
    List<Integer> digit = new ArrayList<>();
    for (int i = 100000; i > 0; i /= 10) {
      digit.add(input / i);
      input %= i;
    }

    List<String> bin = new ArrayList<>();
    for (int i = 0; i < digit.size(); i++) {
      switch (digit.get(i)) {
        case 0:
          bin.add("00");
          break;
        case 1:
          bin.add("01");
          break;
        case 2:
          bin.add("10");
          break;
        case 3:
          bin.add("11");
          break;
      }
    }

    String output = "";
    for (int i = 0; i < bin.size(); i += 2) {
      output += Integer.parseInt(bin.get(i) + bin.get(i + 1), 2);
    }

    System.out.println(output);
  }
}
