package conditional_branch;

public class Task4_7 {
    public static void main(String[] args) {
        String input = "3po2pl4mu3mi6d3";

        // split input into one character
        String[] inputArray = input.split("");
        int ans = Integer.parseInt(input.substring(0, 1));

        for (int i = 1; i < inputArray.length; i += 2) {
            // change the type of calculation depending on the character
            switch (inputArray[i]) {
                case "p":
                    if (inputArray[i + 1].equals("l")) {
                        ans += Integer.parseInt(inputArray[i + 2]);
                    } else {
                        ans = (int) Math.pow((double) ans, Double.parseDouble(inputArray[i + 2]));
                    }
                    i++;
                    break;
                case "m":
                    if (inputArray[i + 1].equals("i")) {
                        ans -= Integer.parseInt(inputArray[i + 2]);
                    } else {
                        ans *= Integer.parseInt(inputArray[i + 2]);
                    }
                    i++;
                    break;
                case "d":
                    ans /= Integer.parseInt(inputArray[i + 1]);
                    break;
            }
        }

        System.out.println(ans);
    }
}
