public static void main(String[] args) {
  // str1 is "OSUSHI", str2 is "OSECHI"
  final String str1 = "OSUSHI";
  final String str2 = "OSECHI";

  String answer = "";
  int index = 0;

  for (int i = 0; i < str1.length(); i++) {
    // compare two chars at the same pos (Note that 'A' is smaller than 'B')
    if (str1.charAt(i) > str2.charAt(i)) {
      answer = str1;
      index = i;
      break;
    } else if (str1.charAt(i) < str2.charAt(i)) {
      answer = str2;
      index = i;
      break;
    }
  }

  System.out.println(answer + " " + index);
}