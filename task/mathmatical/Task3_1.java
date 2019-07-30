public static void main(String[] args) {
    // followings are initial numbers
    int a1 = 0;
    int a2 = 0;
    int a3 = 1;

    // tmp is a temporary variable
    int tmp;
    int an = 0;

    for (int i = 0; i < 5; i++) {
        tmp = a1 + a2 + a3;

        if (i + 1 >= 5) {
            an = tmp;
            break;
        }

        a1 = a2;
        a2 = a3;
        a3 = tmp;
    }

    System.out.println(an);
}