public static void main(String[] args) {
  final String str = "42653";

  // split "str" into single characters
  final String[] strArray = str.split("");

  int sum = 0;

  for (String s : strArray) {
    // add "s" to "sum"
    sum += Integer.parseInt(s);
  }

  System.out.println(sum);
}