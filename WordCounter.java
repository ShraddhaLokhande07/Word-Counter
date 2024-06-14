import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        String filePath = "E:\\Learning Java Programming Language\\code\\answers.txt";  

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            analyzeText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeText(String content) {
        String[] words = content.split("\\W+");
        System.out.println("Total words: " + words.length);

        Map<String, Integer> wordCount = new HashMap<>();
        int totalLength = 0;
        for (String word : words) {
            word = word.toLowerCase();  
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            totalLength += word.length();
        }

        wordCount.forEach((k, v) -> System.out.println(k + ": " + v));

        double averageWordLength = (double) totalLength / words.length;
        System.out.println("Average word length: " + averageWordLength);
    }
}