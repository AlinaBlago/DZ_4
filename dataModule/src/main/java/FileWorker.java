import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class FileWorker {

    String sourceText;

    FileWorker() throws IOException {

        InputStream is = getClass()
                .getClassLoader().getResourceAsStream("text.txt");

        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }


        sourceText = sb.toString();
    }

    public int lengthOfSymbols() {
        return sourceText.length();
    }

    public Map<Character,Integer> sortedNumberOfCharacterEncounters(){
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for (char character : sourceText.toCharArray()) {
            if(map.containsKey(character)){
                int value = map.get(character);
                map.put(character , ++value);
            }else{
                map.put(character , 1);
            }
        }

        Map<Character, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }

    public String showModifiedOCountOfCharacters(){
        Map<Character,Integer> map = sortedNumberOfCharacterEncounters();

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            builder.append( (entry.getKey().equals(' ') ? "space" : (entry.getKey().equals('\n') ? "\\n" : entry.getKey())) + " => " + entry.getValue() + "\n");
        }

        return builder.toString();
    }

    public int countOfWords() {
        String[] words = sourceText.split("\\P{L}+");
        return words.length;
    }

    public Map<String,Integer> sortedNumberOfWordsEncounters(){
        Map<String,Integer> map = new HashMap<String, Integer>();

        for (String word : sourceText.split("\\P{L}+")) {
            if(map.containsKey(word)){
                int value = map.get(word);
                map.put(word , ++value);
            }else{
                map.put(word , 1);
            }
        }

        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }

    public String showModifiedOCountOfWords(){
        Map<String,Integer> map = sortedNumberOfWordsEncounters();

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //(entry.getKey().equals(' ') ? "space" : (entry.getKey().equals('\n') ? "\\n" : entry.getKey()))
            builder.append( entry.getKey() + " => " + entry.getValue() + "\n");
        }

        return builder.toString();
    }

    public String reverseText(){
        String[] sentenses = sourceText.split("\\.");

        StringBuilder result = new StringBuilder();

        for (String sentense : sentenses) {

            String[] words = sentense.split("\\P{L}+");
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
            Collections.reverse(list);

            for (String item : list){
                result.append(item + " ");
            }
            result.append(".\n");


        }

        return result.toString();
    }

}
