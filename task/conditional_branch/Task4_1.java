package conditional_branch;

// AtCoder Beginner Contest 039 - Bを改題
// https://atcoder.jp/contests/abc039/tasks/abc039_c

public class Task4_1 {
  public static void main(String[] args) {
    final String birthday = "4/8";

    // split birthday into moth and day
    final int month = Integer.parseInt(birthday.split("")[0]);
    final int day = Integer.parseInt(birthday.split("")[2]);
    String stone = "";

    // select the birthstone
    switch (month) {
      case 1:
        stone = "garnet";
        break;
      case 2:
        stone = "amethyst";
        break;
      case 3:
        stone = "aquamarine";
        break;
      case 4:
        stone = "diamond";
        break;
      case 5:
        stone = "emerald";
        break;
      case 6:
        stone = "pearl";
        break;
    }

    System.out.println(stone.charAt(day % stone.length()));
  }
}
