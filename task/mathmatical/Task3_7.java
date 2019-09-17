public static void main(String[] args) {
  final int a = 90;
  final int b = 50;
  final int base = 7;

  int count = 0;
  int start, end;

  // set "start" and "end"
  if (a > b) {
    start = b;
    end = a;
  } else {
    start = a;
    end = b;
  }

  for (int i = start; i < end; i++) {
    // count multiples of 7 between start and end
    if (i % base == 0) {
      count++;
    }
  }

  System.out.println(count);
}