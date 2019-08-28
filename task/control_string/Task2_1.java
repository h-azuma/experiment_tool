public static void main(String[] args) {
  final String str = "amklammslo";

  // "buffer" stores characters matched the condition
  String buffer = "";

  for (int i = str.length() - 1; i >= 0; i--) {
    if (str.charAt(i) != 'm' && str.charAt(i) != 'l') {
      buffer += str.charAt(i);
    }
  }

  // output "buffer"
  System.out.println(buffer);
}