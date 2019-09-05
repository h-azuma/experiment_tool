public static void main(String[] args) {
  final List<Integer> radius = Arrays.asList(3, 4, 6);

  // divide in order from big circle to red and white
  int redArea = 0;
  int whiteArea = 0;

  for (int i = radius.size() - 1; i >= 0; i--) {
    // pi has been removed for simplicity
    if (i % 2 == (radius.size() - 1) % 2) {
      redArea += (int) Math.pow(radius.get(i), 2);
    } else {
      whiteArea += (int) Math.pow(radius.get(i), 2);
    }
  }

  System.out.println(redArea - whiteArea + "pi square meters");
}