package control_list;

// AtCoder Beginner Contest 064 - Bを改題
// https://atcoder.jp/contests/abc064/tasks/abc064_b

import java.util.Arrays;
import java.util.List;

public class Task1_7 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5, 7, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(0, 0, 100, 100);

        for (int num : list1) {
            if (num > list2.get(0)) {
                // list2(1) is the second biggest number in list1
                list2.set(1, list2.get(0));
                list2.set(0, num);
            } else if (num < list2.get(3)) {
                list2.set(3, num);
            } else if (num < list2.get(2)) {
                // list2(2) is the second smallest number in list1
                list2.set(2, num);
            }
        }

        System.out.println((list2.get(0) - list2.get(3)) + (list2.get(1) - list2.get(2)));
    }
}
