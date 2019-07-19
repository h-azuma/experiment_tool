package control_list;

// AtCoder Beginner Contest 061 - Bを改題
// https://atcoder.jp/contests/abc061/tasks/abc061_b

import java.util.Arrays;
import java.util.List;

public class Task1_6 {
    public static void main(String[] args){
        List<Integer> list1 = Arrays.asList(1, 3, 2, 3, 1);
        List<Integer> list2 = Arrays.asList(2, 1, 1, 2, 3);
        int num = 0;

        // count pairs of number
        for(int i = 0; i < list1.size(); i++){
            if(!(isRecordedBefore(list1, list2, i))){
                num++;
            }
        }

        // output num
        System.out.println(num);
    }

    private static boolean isRecordedBefore(List<Integer> list1, List<Integer> list2, int now){
        for(int i = 0; i < now; i++){
            if(list1.get(i) == list2.get(now) && list1.get(now) == list2.get(i)){
                return true;
            }
        }
        return false;
    }
}
