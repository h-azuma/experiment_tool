public static void main(String[] args) {
  final String handOfA = "12221";
  final String handOfB = "13312";
  int sum = 0;
  char winner = '-';

  for (int i = 0; i < handOfA.length(); i++) {
    sum += handOfA.charAt(i) - '0'; // convert char to int

    // player lose when "sum" exceed 10
    if (sum >= 10) {
      winner = 'b';
      break;
    }

    sum += handOfB.charAt(i) - '0';
    if (sum >= 10) {
      winner = 'a';
      break;
    }
  }

  System.out.println(winner + " " + sum);
}