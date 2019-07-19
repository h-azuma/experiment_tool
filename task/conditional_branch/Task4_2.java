package conditional_branch;

public class Task4_2 {
    public static void main(String[] args){
        // input current time and season
        String time = "0628PM";
        String season = "su";

        int hour = Integer.parseInt(time.substring(0, 2));

        // change hour into 24-hour clock
        if(time.charAt(4) == 'P'){
            hour += 12;
        }

        int dayThreshold = 0;
        int nightThreshold = 0;
        switch(season){
            case "sp":
            case "au":
                dayThreshold = 6;
                nightThreshold = 18;
                break;
            case "su":
                dayThreshold = 5;
                nightThreshold = 19;
                break;
            case "wi":
                dayThreshold = 7;
                nightThreshold = 17;
                break;
        }

        if(hour < dayThreshold || nightThreshold <= hour){
            System.out.println("night");
        }else{
            System.out.println("daytime");
        }
    }
}
