package conditional_branch;

// AtCoder Beginner Contest 039 - Bを改題
// https://atcoder.jp/contests/abc039/tasks/abc039_c

import java.util.Arrays;
import java.util.List;

public class Task4_4 {
  public static void main(String[] args) {
    // set initial today's temperature
    int temperature = 15;

    // weather is the weather until yesterday
    final List<String> weather = Arrays.asList("rainy", "snowy", "cloudy", "sunny", "sunny");

    for (String wh : weather) {
      switch (wh) {
        case "sunny":
          temperature += 3;
          break;
        case "cloudy":
          break;
        case "rainy":
          temperature -= 2;
          break;
        case "snowy":
          temperature /= 2;
          break;
      }
    }

    System.out.println(temperature);
  }
}
