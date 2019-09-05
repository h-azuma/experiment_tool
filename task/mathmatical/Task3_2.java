public static void main(String[] args) {
  final int sum = 10;
  final int legs = 36;

  int human = 0;
  int turtle = sum;

  // human has 2 legs and turtle has 4 legs
  while (!(2 * human + 4 * turtle == legs && human + turtle == sum)) {
    // Reduce turtle number and add human number
    human++;
    turtle--;
  }

  System.out.println(human);
}