import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class ConsumerApp {
    public static final String FILE_PATH = "./question2/src/main/resources/gameScores.txt";

    public static void main(String[] args) {
        init();
    }

    static void init() {
        Path path = Paths.get(FILE_PATH);
        var opt = readFileContent(path);
        opt.ifPresentOrElse(System.out::println, () -> System.out.println("No record found"));
    }

    /**
     * The method reads all lines from a file into a Stream.
     * @param path
     * @return Optional of String
     */
    static Optional<String> readFileContent(Path path) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(contentBuilder.toString());
    }
}
