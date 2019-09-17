public static void main(String[] args) {
  final String str = "abcaabc";
  final int windowSize = 2;

  // "set" stores substring of "str"
  Set<String> set = new HashSet<>();

  for (int i = 0; i < str.length() - windowSize + 1; i++) {
    set.add(str.substring(i, i + windowSize));
  }

  // output the number of substrings
  System.out.println(set.size());
}