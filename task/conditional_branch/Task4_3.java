public static void main(String[] args) {
  final String week = "Sat";
  int firstDay = 1;

  switch (week) {
    case "Mon":
      firstDay += 5;
      break;
    case "Tue":
      firstDay += 6;
      break;
    case "Wed":
      // 1st is Wednesday
      break;
    case "Thu":
      firstDay++;
      break;
    case "Fri":
      firstDay += 2;
      break;
    case "Sat":
      firstDay += 3;
      break;
    case "Sun":
      firstDay += 4;
      break;
  }

  List<Integer> candidate = new ArrayList<>();
  for (int i = firstDay; i <= 31; i += 7) {
    candidate.add(i);
  }

  System.out.println(candidate.get(candidate.size() - 1));
}