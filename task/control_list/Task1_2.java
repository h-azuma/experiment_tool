public static void main(String[] args) {
  final List<Integer> list = Arrays.asList(3, 5, 2, 7, 4);
  final int filter = 18;

  // convert integer to binary
  final String binary = Integer.toBinaryString(filter);

  int sum = 0;

  for (int i = 0; i < binary.length(); i++) {
    if (binary.charAt(i) == '1') {
      // add list(i) to sum
      sum += list.get(i);
    }
  }

  System.out.println(sum);
}