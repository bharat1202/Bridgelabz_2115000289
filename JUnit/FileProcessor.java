import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

class FileProcessor {
    void writeToFile(String filename, String content) throws IOException {
        Files.write(Paths.get(filename), content.getBytes());
    }

    String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}

public class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";
    FileProcessor fileProcessor;

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(TEST_FILE, content);
        assertEquals(content, fileProcessor.readFromFile(TEST_FILE));
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(TEST_FILE, "Sample Content");
        assertTrue(Files.exists(Paths.get(TEST_FILE)));
    }

    @Test
    void testReadNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
    }
}
