package mathmatical;

// AtCoder Beginner Contest 026 - Bを改題
// https://atcoder.jp/contests/abc026/tasks/abc026_b

import java.util.Arrays;
import java.util.List;

public class Task3_3 {
    public static void main(String[] args){
        List<Integer> radius = Arrays.asList(3, 4, 6);

        // divide in order from big circle to red and white
        int redCircleArea = 0;
        int whiteCircleArea = 0;

        for(int i = radius.size() - 1; i >= 0; i--){
            // pi has been removed for simplicity
            if(i % 2 == (radius.size() - 1) % 2) {
                redCircleArea += (int) Math.pow(radius.get(i), 2);
            }else{
                whiteCircleArea += (int) Math.pow(radius.get(i), 2);
            }
        }

        System.out.println(redCircleArea - whiteCircleArea + "pi square meters");
    }
}
