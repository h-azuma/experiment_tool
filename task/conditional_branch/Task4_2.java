public static void main(String[] args) {
  // input current time and season
  final String time = "0628PM";
  final String season = "summer";

  int hour = Integer.parseInt(time.substring(0, 2));
  int dayThreshold = 0;
  int nightThreshold = 0;

  // change hour into 24-hour clock
  if (time.charAt(4) == 'P') {
    hour += 12;
  }

  switch (season) {
    case "spring":
    case "autumn":
      dayThreshold = 6;
      nightThreshold = 18;
      break;
    case "summer":
      dayThreshold = 5;
      nightThreshold = 19;
      break;
    case "winter":
      dayThreshold = 7;
      nightThreshold = 17;
      break;
  }

  if (hour < dayThreshold || nightThreshold <= hour) {
    System.out.println("night");
  } else {
    System.out.println("daytime");
  }
}