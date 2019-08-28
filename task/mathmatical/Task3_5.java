package mathmatical;

// AtCoder Beginner Contest 035 - Bを改題
// https://atcoder.jp/contests/abc035/tasks/abc035_b

public class Task3_5 {
  public static void main(String[] args) {
    // initial coordinate is (0, 0)
    int[] coordinate = new int[2];
    final String command = "URLLDU";

    String[] commandArray = command.split("");
    for (String cmd : commandArray) {
      switch (cmd) {
        case "U":
          coordinate[0]++;
          break;
        case "D":
          coordinate[0]--;
          break;
        case "R":
          coordinate[1]++;
          break;
        case "L":
          coordinate[1]--;
          break;
      }
    }

    // output final coordinate
    System.out.println("(" + coordinate[0] + ", " + coordinate[1] + ")");
  }
}
