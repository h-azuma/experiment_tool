public static void main(String[] args) {
  // prepare prime numbers
  final List<Integer> primeNumbers = Arrays.asList(2, 3, 5, 7, 11, 13, 17);

  int target = 220;
  int i = 0;
  int count = 0;

  while (target != 1) {
    if (target % primeNumbers.get(i) == 0) {
      target /= primeNumbers.get(i);
      count++;
    } else {
      // look at next prime number
      i++;
    }
  }

  System.out.println(count);
}