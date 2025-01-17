//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link up to next )
        int currentIndex = 0;

        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if (openBracket < 0) {
                break;
            }
            
            currentIndex++;

            if (openBracket - 1 >= 0 && markdown.charAt(openBracket - 1) == '!') {
                continue;
            }

            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket < 0) {
                break;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            if (openParen < 0) {
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if (closeParen < 0) {
                break;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

            // check if there is another [ in the file to prevent infinite looping
            int nextBracket = markdown.indexOf("[", currentIndex);
            if (nextBracket < 0) {
                break;
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
