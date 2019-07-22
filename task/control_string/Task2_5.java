package control_string;

// AtCoder Beginner Contest 045 - Bを改題
// https://atcoder.jp/contests/abc044/tasks/abc045_b

public class Task2_5 {
    public static void main(String[] args) {
        String HandOfA = "bcaac";
        String HandOfB = "acbba";
        String HandOfC = "cacbb";
        char turn = 'a';
        char winner;

        while (true) {
            // can win when lose all characters in hand
            // determine the person who can act next by the head character
            if (turn == 'a') {
                turn = HandOfA.charAt(0);
                HandOfA = HandOfA.substring(1);
                if (HandOfA.length() == 0) {
                    winner = 'a';
                    break;
                }
            } else if (turn == 'b') {
                turn = HandOfB.charAt(0);
                HandOfB = HandOfB.substring(1);
                if (HandOfB.length() == 0) {
                    winner = 'b';
                    break;
                }
            } else if (turn == 'c') {
                turn = HandOfC.charAt(0);
                HandOfC = HandOfC.substring(1);
                if (HandOfC.length() == 0) {
                    winner = 'c';
                    break;
                }
            }
        }

        System.out.println(winner);
    }
}
