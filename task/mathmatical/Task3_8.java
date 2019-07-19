package mathmatical;

// AtCoder Beginner Contest 051 - Bを改題
// https://atcoder.jp/contests/abc051/tasks/abc051_b

public class Task3_8 {
    public static void main(String[] args){
        // 0 <= x, y, z <= max
        int max = 2;

        // x + y + z = sum
        int sum = 2;
        int count = 0;

        for (int x = 0; x <= max; x++) {
            for (int y = 0; y <= max; y++) {
                int z = sum - x - y;
                if (0 <= z && z <= max) {
                    count++;
                }else if(z < 0){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
