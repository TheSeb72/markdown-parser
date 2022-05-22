import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path path = Path.of("test-file.md");
        String readString = Files.readString(path);
        ArrayList<String> links = MarkdownParse.getLinks(readString);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }
    
    @Test
    public void snippet1Test() throws IOException {
       Path fileName = Path.of("snippet1Tester.md");
       String readString = Files.readString(fileName);
       ArrayList<String> links = MarkdownParse.getLinks(readString);
       assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), links);
    }
    
    @Test
    public void snippet2Test() throws IOException {
       Path fileName = Path.of("snippet2Tester.md");
       String readString = Files.readString(fileName);
       ArrayList<String> links = MarkdownParse.getLinks(readString);
       assertEquals(List.of("a.com(())", "example.com"), links);
    }
    
    @Test
    public void snippet3Test() throws IOException {
       Path fileName = Path.of("snippet3Tester.md");
       String readString = Files.readString(fileName);
       ArrayList<String> links = MarkdownParse.getLinks(readString);
       assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links);
    }
    
}
