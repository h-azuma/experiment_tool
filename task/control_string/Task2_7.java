package control_string;

public class Task2_7 {
    public static void main(String[] args) {
        String str = "HAHOGAKZZFEGA";
        char[] strArray = str.toCharArray();
        int start = 0;
        int end = 0;
        boolean flg = false;

        for (int i = 0; i < strArray.length; i++) {
            // check the location of 'A'and 'Z'
            if (strArray[i] == 'A' && !(flg)) {
                start = i;
                flg = true;
            } else if (strArray[i] == 'Z') {
                end = i;
            }
        }

        // output distance between 'A' and 'Z'
        System.out.println(end - start + 1);
    }
}
