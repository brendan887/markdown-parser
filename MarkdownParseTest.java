import static org.junit.Assert.*; // imports necessary libraries for junit tests
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    
    @Test // specifies that the following method is a test
    public void addition() { // new unit test method
        assertEquals(2, 1+1); // checks whether the two arguments are equal
    }

    @Test
    public void getLinksTestOne() throws IOException{
        String fileName = "test-file.md";
        List generatedList = MarkdownParse.getLinks(Files.readString(Path.of(fileName)));
        List testList = List.of("https://something.com", "some-thing.html");
        assertEquals(generatedList, testList);
    }

    @Test
    public void getLinksTestTwo() throws IOException{
        String fileName = "test-file-2.md";
        List generatedList = MarkdownParse.getLinks(Files.readString(Path.of(fileName)));
        List testList = List.of("link1.html", "link2.com");
        assertEquals(generatedList, testList);
    }

    @Test
    public void getLinksTestThree() throws IOException{
        String fileName = "test-file-3.md";
        List generatedList = MarkdownParse.getLinks(Files.readString(Path.of(fileName)));
        List testList = List.of("https://youtube.com", "link2");
        assertEquals(generatedList, testList);
    }

    @Test
    public void snippet1() throws IOException{
        String fileName = "snippet1.md";
        List generatedList = MarkdownParse.getLinks(Files.readString(Path.of(fileName)));
        List testList = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(generatedList, testList);
    }

    @Test
    public void snippet2() throws IOException{
        String fileName = "snippet2.md";
        List generatedList = MarkdownParse.getLinks(Files.readString(Path.of(fileName)));
        List testList = List.of("a.com", "a.com(())", "example.com");
        assertEquals(generatedList, testList);
    }

    @Test
    public void snippet3() throws IOException{
        String fileName = "snippet3.md";
        List generatedList = MarkdownParse.getLinks(Files.readString(Path.of(fileName)));
        List testList = List.of("https://www.twitter.com",
            "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
            "https://cse.ucsd.edu/");
        assertEquals(generatedList, testList);
    }
}
