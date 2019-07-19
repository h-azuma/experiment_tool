package control_string;

// AtCoder Beginner Contest 032 - Bを改題
// https://atcoder.jp/contests/abc032/tasks/abc032_b

import java.util.HashSet;
import java.util.Set;

public class Task2_3 {
    public static void main(String[] args){
        String str = "abcabc";

        for(int i = 1; i <= 3; i++){
            // "set" is a set of unique strings of length i
            Set<String> set = new HashSet<>();
            for(int j = 0; j < str.length() - i + 1; j++){
                set.add(str.substring(j, j + i));
            }
            // output the number of species of the strings in "set"
            System.out.println(set.size());
        }
    }
}
