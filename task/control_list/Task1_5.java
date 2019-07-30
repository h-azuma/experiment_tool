public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    String input = "0011B10";
    String[] inputArray = input.split("");

    for (String character : inputArray) {
        if (character.equals("0") || character.equals("1")) {
            list.add(character);
        } else {
            if (list.size() != 0) {
                list.remove(list.size() - 1);
            }
        }
    }

    for (String output : list) {
        System.out.print(output);
    }
}