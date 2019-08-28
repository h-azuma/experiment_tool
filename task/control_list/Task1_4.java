public static void main(String[] args) {
  final List<String> list = Arrays.asList("january", "february", "march", "april", "may", "june");

  int n = 0;

  for (int i = 0; i < list.size(); i++) {
    // split a string into single chars array
    final String[] strArray = list.get(i).split("");

    for (String character : strArray) {
      if (character.equals("r")) {
        // count the number of strings containing "r"
        n++;
        break;
      }
    }
  }

  System.out.println(n);
}