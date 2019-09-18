public static void main(String[] main) {
  // prepare two lists
  final List<Character> list1 = Arrays.asList('i', 'a', 'c', 'f');
  final List<Character> list2 = Arrays.asList('m', 'f', 'i', 'w');

  for (int i = 0; i < list1.size(); i++) {
    for (int j = 0; j < list2.size(); j++) {
      // if arr1[i] equals arr2[j], print i and j
      if (list1.get(i) == list2.get(j)) {
        System.out.println(i);
        System.out.println(j);
      }
    }
  }
}