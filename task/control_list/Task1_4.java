package control_list;

// AtCoder Beginner Contest 029 - Bを改題
// https://atcoder.jp/contests/abc029/tasks/abc029_b

import java.util.Arrays;
import java.util.List;

public class Task1_4 {
    public static void main(String[] args){
        List<String> list = Arrays.asList("january", "february", "march", "april", "may", "june");

        int count = 0;

        for(String str : list){
            // split a string into single characters
            String[] strArray = str.split("");
            for(String character : strArray){
                if(character.equals("r")){
                    // count records the number of strings containing "r"
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
