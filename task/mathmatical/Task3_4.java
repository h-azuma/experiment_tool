public static void main(String[] args) {
  // consider clock
  final int shortHand = 15;
  final int longHand = 17;

  // (6.0 / 0.5) is the angle (long / short) hand exceed per 1min.
  double longHandAngle = (double) longHand * 6.0;
  double shortHandAngle = (double) (shortHand % 12) * 30.0 + (double) (longHand) * 0.5;

  if (shortHandAngle >= longHandAngle) {
    System.out.println(shortHandAngle - longHandAngle);
  } else {
    System.out.println(longHandAngle - shortHandAngle);
  }
}