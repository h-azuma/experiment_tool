public static void main(String[] args) {
  final List<Integer> list1 = Arrays.asList(1, 4, 6, 9);
  final List<Integer> list2 = Arrays.asList(2, 6, 10, 8);
  int pairs = 0;

  for (int s1 : list1) {
    for (int s2 : list2) {
      if (Math.abs(s1 - s2) <= 1) {
        // count the number of pairs matched the condition
        pairs++;
      }
    }
  }

  // output number of pairs
  System.out.println(pairs);
}