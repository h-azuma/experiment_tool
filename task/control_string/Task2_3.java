public static void main(String[] args) {
    String str = "abcabc";

    for (int i = 1; i <= 3; i++) {
        // "set" is a set of unique strings of length i
        Set<String> set = new HashSet<>();
        for (int j = 0; j < str.length() - i + 1; j++) {
            set.add(str.substring(j, j + i));
        }
        // output the number of species of the strings in "set"
        System.out.println(set.size());
    }
}