import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() {
        Path path = Path.of("test-file.md");
        String readString = Files.readString(path);
        ArrayList<String> links = MarkdownParse.getLinks(readString);
        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }
}
