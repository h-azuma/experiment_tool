public static void main(String[] args) {
  final String birthday = "0605";

  // get month and day from date
  final int month = Integer.parseInt(birthday.substring(0, 2));
  final int day = Integer.parseInt(birthday.substring(2, 4));

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