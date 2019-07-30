public static void main(String[] args) {
    String str = "DIDIDRIIID";
    int x = 0;

    // length of "str" is 10
    for (int i = 0; i < str.length(); i++) {
        char[] c = str.toCharArray();
        if (c[i] == 'D') {
            x--;
        } else if (c[i] == 'I') {
            x++;
        } else if (c[i] == 'R') {
            StringBuffer sb = new StringBuffer(str);
            str = sb.reverse().toString();
            // reversed "str" is "DIIIRDIDID"
        }
    }

    System.out.println(x);
}