package control_list;

// AtCoder Beginner Contest 014 - Bを改題
// https://atcoder.jp/contests/abc014/tasks/abc014_2

import java.util.Arrays;
import java.util.List;

public class Task1_2 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(3, 5, 2, 7, 4);
        int num = 18;

        // convert num into binary
        String bin = Integer.toBinaryString(num);
        String[] binArray = bin.split("");

        int sum = 0;

        for(int i = 0; i < binArray.length; i++){
            int digit = Integer.parseInt(binArray[i]);
            if(digit == 1){
                // add factor of list
                sum += list.get(i);
            }
        }

        System.out.println(sum);
    }
}
