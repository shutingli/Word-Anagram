import java.util.*;

public class AnagramTest{

    public static void main(String[] args) {
        Anagram.createWordMap();
        nullInputTest();
        noMatchInputTest();
        invalidInputTest();
        lowerCaseInputTest();
        upperCaseInputTest();
        mixedCaseInputTest();

    }

    public static void nullInputTest(){
        System.out.println("Running nullInputTest");
        List<String> answer = Anagram.findHelper("");
        if(answer.size() != 0){
            System.out.println("FAILED!!! Expected output to be empty, instead got " + answer);
        } else{
            System.out.println("PASSED!!! nullInputTest");
        }
    }

    public static void noMatchInputTest(){
        System.out.println("Running noMatchInputTest");
        List<String> answer = Anagram.findHelper("abcdefg");
        if(answer.size() != 0){
            System.out.println("FAILED!!! Expected output to be empty, instead got " + answer);
        } else{
            System.out.println("PASSED!!! noMatchInputTest");
        }
    }

    public static void invalidInputTest(){
        System.out.println("Running invalidInputTest");
        List<String> answer = Anagram.findHelper("1234567890abcdefg");
        if(answer.size() != 0){
            System.out.println("FAILED!!! Expected output to be empty, instead got " + answer);
        } else{
            System.out.println("PASSED!!! invalidInputTest");
        }
    }

    public static void lowerCaseInputTest(){
        System.out.println("Running lowerCaseInputTest");
        List<String> answer = Anagram.findHelper("beat");
        List<String> expected = new ArrayList<>(Arrays.asList("abet", "bate", "beat", "Beta", "beta"));
        if(!answer.equals(expected)){
            System.out.println("FAILED!!! Expected output to be " + expected + ", instead got " + answer);
        } else{
            System.out.println("PASSED!!! lowerCaseInputTest");
        }
    }

    public static void upperCaseInputTest(){
        System.out.println("Running upperCaseInputTest");
        List<String> answer = Anagram.findHelper("TEST");
        List<String> expected = new ArrayList<>(Arrays.asList("sett", "stet", "test"));
        if(!answer.equals(expected)){
            System.out.println("FAILED!!! Expected output to be " + expected + ", instead got " + answer);
        } else{
            System.out.println("PASSED!!! upperCaseInputTest");
        }
    }

    public static void mixedCaseInputTest(){
        System.out.println("Running mixedCaseInputTest");
        List<String> answer = Anagram.findHelper("StAtE");
        List<String> expected = new ArrayList<>(Arrays.asList("State", "state", "taste", "Tates", "testa"));
        if(!answer.equals(expected)){
            System.out.println("FAILED!!! Expected output to be " + expected + ", instead got " + answer);
        } else{
            System.out.println("PASSED!!! mixedCaseInputTest");
        }
    }
}
