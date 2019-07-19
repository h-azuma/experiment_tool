package conditional_branch;

import java.util.Arrays;
import java.util.List;

public class Task4_4 {
    public static void main(String[] args){
        int templeture = 15;
        List<String> weather = Arrays.asList("rainy", "snowy", "cloudy", "sunny", "sunny");

        for(String wh : weather){
            switch (wh){
                case "sunny":
                    templeture += 3;
                    break;
                case "cloudy":
                    break;
            }
        }
    }
}
