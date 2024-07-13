import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounterTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome : Word Counter Tool");
            System.out.println("Created by:- Shashank Karan");
            System.out.print("Enter a text (or 'quit' to exit): ");
            String text = scanner.nextLine();

            if (text.equalsIgnoreCase("quit")) {
                break;
            }

            Map<String, Integer> wordCountMap = countWords(text);

            System.out.println("Word Count:");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println();
        }

        scanner.close();
    }

    private static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            word = word.toLowerCase(); // ignore case
            if (wordCountMap.containsKey(word)) {
                int count = wordCountMap.get(word) + 1;
                wordCountMap.put(word, count);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }
}
