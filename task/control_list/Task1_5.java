public static void main(String[] args) {
  final String input = "012B81A";
  final String[] list = input.split("");
  String output = "";

  for (String c : list) {
    if (c.equals("B")) {
      // backspace to buffer
      output = output.substring(0, output.length() - 1);
    } else {
      // append to buffer
      output += c;
    }
  }

  System.out.println(output);
}