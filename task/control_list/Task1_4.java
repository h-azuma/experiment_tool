public static void main(String[] args) {
    List<String> list = Arrays.asList("january", "february", "march", "april", "may", "june");

    int count = 0;

    for (String str : list) {
        // split a string into single characters
        String[] strArray = str.split("");
        for (String character : strArray) {
            if (character.equals("r")) {
                // count records the number of strings containing "r"
                count++;
                break;
            }
        }
    }

    System.out.println(count);

}