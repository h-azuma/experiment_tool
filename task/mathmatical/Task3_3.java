public static void main(String[] args) {
  final List<Integer> radius = Arrays.asList(3, 4, 6);
  int redArea = 0;
  int whiteArea = 0;

  for (int i = 0; i < radius.size(); i++) {
    // pi has been removed for simplicity
    final int area = radius.get(i) * radius.get(i);

    // even is red, odd is white
    if (i % 2 == 0) {
      redArea += area;
    } else {
      whiteArea += area;
    }
  }

  System.out.println(redArea - whiteArea);
}