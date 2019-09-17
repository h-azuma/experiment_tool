public static void main(String[] args) {
  final List<String> list1 = Arrays.asList("s","u","m","m","e","r");
  final List<String> list2 = Arrays.asList("w","i","n","t","e","r");

  // prepare two buffers
  String buffer1 = "";
  String buffer2 = "";

  for (int i = 0; i < list1.size(); i++) {
    if (list1.get(i) != list2.get(i)) {
      // store each characters
      buffer1 += list1.get(i);
      buffer2 += list2.get(i);
    }
  }

  System.out.println(buffer1 + buffer2);
}