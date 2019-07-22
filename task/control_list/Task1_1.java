package control_list;

// AtCoder Beginner Contest 009 - Bを改題
// https://atcoder.jp/contests/abc009/tasks/abc009_2

import java.util.Arrays;
import java.util.List;

public class Task1_1 {
    public static void main(String[] args) {
        // prepare an integer list
        List<Integer> list = Arrays.asList(1200, 300, 1200, 500, 800);

        int second = 0;
        int max = 0;

        for (int num : list) {
            if (num > max) {
                // update max and second
                second = max;
                max = num;
            } else if (num > second && num < max) {
                second = num;
            }
        }

        System.out.println(second);
    }
}
