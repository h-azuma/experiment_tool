public static void main(String[] args) {
  // "pastWeathers" is the list of weather until yesterday
  final List<String> pastWeathers = Arrays.asList("rainy", "rainy", "snowy", "cloudy", "sunny");

  // set initial today's temperature
  int temperature = 15;

  for (String weather : pastWeathers) {
    switch (weather) {
      case "sunny":
        temperature += 3;
        break;
      case "cloudy":
        // do nothing
        break;
      case "rainy":
        temperature -= 2;
        break;
      case "snowy":
        temperature /= 2;
        break;
    }
  }

  System.out.println(temperature);
}