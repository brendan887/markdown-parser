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
    public void getLinksTest() throws IOException{
        String fileName = "test-file.md";
        List generatedList = MarkdownParse.getLinks(Files.readString(Path.of(fileName)));
        List testList = List.of("https://something.com", "some-thing.html");
        assertEquals(generatedList, testList);
    }
}
