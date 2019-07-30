public static void main(String[] args) {
    String str = "amkllannsnom";

    // store the character of the string one by one
    List<String> stringList = new ArrayList<String>(Arrays.asList(str.split("")));

    stringList.removeIf(s -> s.matches("l|m|n"));

    // output the remained string
    for (int i = stringList.size() - 1; i >= 0; i--) {
        System.out.print(stringList.get(i));
    }
}