package control_string;

// AtCoder Beginner Contest 007 - Bを改題
// https://atcoder.jp/contests/abc007/tasks/abc007_2

public class Task2_2 {
    public static void main(String[] args){
        char ascii = 65; // "65" is "A"
        String[] character = new String[26];

        // set from "A" to "Z" to character[]
        for(int i = 0; i < character.length; i++){
            character[i] = String.valueOf((char)(ascii + i));
        }

        String str1 = "OSUSHI";
        String str2 = "OSECHI";

        String[] str1Array = str1.split("");
        String[] str2Array = str2.split("");

        System.out.print("str1 is ");
        for(int i = 0; i < str1Array.length; i++){
            int str1Num = -1;
            int str2Num = -1;
            for(int j = 0; j < character.length; j++){
                if(str1Array[i].equals(character[j])){
                    str1Num = j;
                }
                if(str2Array[i].equals(character[j])){
                    str2Num = j;
                }
            }
            if(str1Num > str2Num){
                System.out.print("behind");
                break;
            }else if(str1Num < str2Num){
                System.out.print("in front of");
                break;
            }
        }
        System.out.println(" str2 in dictionary.");
    }
}
