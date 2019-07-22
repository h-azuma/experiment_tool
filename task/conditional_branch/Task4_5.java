package conditional_branch;

public class Task4_5 {
    public static void main(String[] args) {
        String date = "0613";

        // get month and day from date
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(2, 4));
        int diff = 0;

        for (int i = 1; i < month; i++) {
            switch (i) {
                case 2:
                    diff -= 2;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    break;
                default:
                    // if do not apply above, increment
                    diff += 1;
            }
        }

        System.out.println((month - 1) * 30 + diff + day);
    }
}
