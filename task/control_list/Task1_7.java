public static void main(String[] args) {
  final String str1 = "summer";
  final String str2 = "winter";
  // prepare two buffers
  String buffer1 = "";
  String buffer2 = "";
  for (int i = 0; i < str1.length(); i++) {
    if (str1.charAt(i) != str2.charAt(i)) {
      // store character
      buffer1 += str1.charAt(i);
      buffer2 += str2.charAt(i);
    }
  }
  System.out.println(buffer1 + buffer2);
}