public static void main(String[] args) {
  final int totalLegs = 36;

  int human = 0;
  int turtle = 10;

  // human has 2 legs and turtle has 4 legs
  while (2 * human + 4 * turtle != totalLegs) {
    // Reduce turtle number and add human number
    human++;
    turtle--;
  }

  System.out.println(human);
}