import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Week 2 Exercise — String analysis (implement TODO methods).
 *
 * Compile: javac TextAnalyzer.java
 * Run:     java TextAnalyzer
 */


public class TextAnalyzer {

    public static int wordCount(String text) {

        text = text.replace(",", "");
        String[] newText = text.split(" ");

        if (text.isEmpty()) {
            return 0;
        } else {
            return newText.length;
        }
    }

    public static boolean isPalindrome(String token) {
        token = token.toLowerCase();
        token = token.replace(" ", "");
        token = token.replace(",", "");

        String reversed = new StringBuilder(token).reverse().toString();

        return token.equals(reversed);

    }

    public static int countOccurrences(String haystack, String needle) {
        
        if(haystack== null || needle==null) {
            return 0;
        } 

        int count = 0;

        Pattern pattern = Pattern.compile(needle);
        Matcher matcher = pattern.matcher(haystack);

        while(matcher.find()) {
            count = count + 1;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Path p = Path.of("sample.txt");
        String body = Files.readString(p);
        System.out.println("words=" + wordCount(body));
        System.out.println("palindrome(Radar)=" + isPalindrome("Radar"));
        System.out.println("occurrences of 'QA'=" + countOccurrences(body, "QA"));
    }
}
