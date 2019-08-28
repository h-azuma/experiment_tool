public static void main(String[] args) {
  final String str = "ZAMMAZZFA";

  int begin = 0;
  int end = 0;
  boolean foundA = false;

  for (int i = 0; i < str.length(); i++) {
    // check the index of 'A' and 'Z'
    if (str.charAt(i) == 'A' && !(foundA)) {
      begin = i;
      foundA = true;
    } else if (str.charAt(i) == 'Z') {
      end = i;
    }
  }

  // output length of substring between 'A' and 'Z'
  System.out.println(end - begin - 1);
}