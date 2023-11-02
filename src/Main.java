import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;



public class Main {
    public static void main(String[] args) {
        countProgram();


    }

    public static void countProgram() {
        String line = "пе тттт еер";
        String[] res = line.split(" ");
        String longestUniqueWord = "";
        int k = 1000;

        for (int i = 0; i < res.length; i++) {
            int chet = 0;

            for (int j = 0; j < res[i].length(); j++) {
                for (int p = j + 1; p < res[i].length(); p++) {
                    if (res[i].charAt(j) == res[i].charAt(p)) {
                        chet++;
                        break;
                    }
                }
            }

            int charCount = res[i].length() - chet;
            System.out.println(charCount);

            if (charCount < k) {
                k = charCount;
                longestUniqueWord = res[i];
            }
        }

        System.out.println(longestUniqueWord);
    }

    public static void fourTex(){
        String a = "One two three раз два три one1 two2 123 ";
        String[] line = a.split(" ");
        String[] word = Arrays.stream(line).filter(x -> x.matches("^[a-zA-Z]+$")).toArray(String[]::new);
        for(int i = 0;i<word.length;i++){
            System.out.println(word[i]);
        }
    }
    public static int threeHelp(String a){
       int s = a.chars().mapToObj(x -> (char) x).collect(groupingBy(Function.identity(),counting())).values().stream().mapToInt(Long::intValue).max().orElse(0);
       return s;
    }
    public static void threeTex(){
        String line = "ff abbbbbbbb f 1234 jkjk";
        String[] res = line.split(" ");
        String word = Arrays.stream(res).sorted((x1,x2) -> (threeHelp(x2)-threeHelp(x1))).findFirst().orElse("");
        System.out.println(word);


    }
    public static void twoTex() {
        ArrayList<String> s = new ArrayList<>();
        s.add("пока");
        s.add("луна");
        s.forEach(x -> System.out.println(x.charAt(((x.length()/2))-1) + " " + x.charAt((x.length())/2)));

    }
    public static int helpOne(Integer a){
        int k = 0;
        while(a!=0){
            k+=(a%10);
            a/=10;
        }
        return k;
    }
    public static void oneTex(){
        ArrayList<Integer> s = new ArrayList<>();
        for(int i = 0 ;i<=300;i++){
            s.add(i);
        }
        Stream<Integer> stream = s.stream();
        stream.filter(x -> ((x%4==0) && (x%6!=0)) && (helpOne(x)<10)).forEach(x -> System.out.println(x));
    }
}