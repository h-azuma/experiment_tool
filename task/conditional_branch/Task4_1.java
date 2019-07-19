package conditional_branch;

public class Task4_1 {
    public static void main(String[] args){
        String birthday = "4/8";

        // split birthday into moth and day
        int month = Integer.parseInt(birthday.split("")[0]);
        int day = Integer.parseInt(birthday.split("")[2]);
        String stone = "";

        // select the birthstone
        switch(month){
            case 1:
                stone = "garnet";
                break;
            case 2:
                stone = "amethyst";
                break;
            case 3:
                stone = "aquamarine";
                break;
            case 4:
                stone = "diamond";
                break;
            case 5:
                stone = "emerald";
                break;
            case 6:
                stone = "pearl";
                break;
        }

        System.out.println(stone.charAt(day % stone.length()));
    }
}
