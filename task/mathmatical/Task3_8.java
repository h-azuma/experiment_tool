public static void main(String[] args) {
  final int a = 84;
  final int b = 48;
  final int number = 7;
  int divisors = 0;

  int start, end;
  // set start and end
  if (a > b) {
    start = b;
    end = a;
  } else {
    start = a;
    end = b;
  }

  for (int i = start; i < end; i++) {
    // count divisors between start and end
    if (i % number == 0) {
      divisors++;
    }
  }

  System.out.println(divisors);
}