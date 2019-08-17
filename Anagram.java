import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Anagram {
    private static HashMap<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        createWordMap();
        while(true) {
            findAnagram();
        }
    }

    public static void createWordMap(){
        try {
            URL oracle = new URL("https://raw.githubusercontent.com/lad/words/master/words");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                char[] temp = inputLine.toLowerCase().toCharArray();
                Arrays.sort(temp);
                if(!map.containsKey(String.valueOf(temp))){
                    map.put(String.valueOf(temp), new LinkedList<String>());
                }
                map.get(String.valueOf(temp)).add(inputLine);
            }
            in.close();
        } catch (Exception exp){
            System.out.println("Failed to load words from dictionary: " + exp.getMessage());
            System.exit(1);
        }
    }

    private static void findAnagram() {
        System.out.println("Please enter characters below to find all anagrams or Control + C to exit:");
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        try {
            String input = reader.readLine();
            List<String> answer = findHelper(input);
            for (String s : answer)
                System.out.println(s);
        } catch (Exception exp){
            System.out.println("Failed to read from STDIN: " + exp.getMessage());
            System.exit(1);
        }
    }

    public static List<String> findHelper(String toFind){
        char[] temp = toFind.toLowerCase().toCharArray();
        Arrays.sort(temp);
        String sorted = String.valueOf(temp);
        if(!map.containsKey(sorted)){
            System.out.println("No anagram in the dictionary for characters: " + toFind);
            return new ArrayList<>();
        }
        return map.get(sorted);
    }
}
