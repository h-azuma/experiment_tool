public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 11, 14, 25, 34);

    // set 10 as the threshold
    int threshold = 10;
    int sum = 0;

    for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i + 1) - list.get(i) >= threshold) {
            sum += 10;
        } else {
            // add the difference between list(i + 1) and list(i) to sum
            sum += list.get(i + 1) - list.get(i);
        }
    }

    System.out.println(sum);
}