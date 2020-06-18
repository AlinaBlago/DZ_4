import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {

        FileWorker a = new FileWorker();
        System.out.println("Count of symbols: \n" + a.lengthOfSymbols());
        System.out.println("\nNumber of characters encounters: \n" + a.showModifiedOCountOfCharacters());
        System.out.println("Count of words: \n" + a.countOfWords());
        System.out.println("\nNumber of words encounters: \n" + a.showModifiedOCountOfWords());
        System.out.println("Text Reverse: \n" +  a.reverseText());


        
    }
}
