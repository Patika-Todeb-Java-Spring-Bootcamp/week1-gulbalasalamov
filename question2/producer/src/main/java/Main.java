import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var text = readInput();
        var opt = validateInput(text);
        Path path = Paths.get(Constants.FILE_PATH);
        opt.ifPresentOrElse(x -> writeFile(path,x),
                () -> System.out.println(Constants.WARNING_MSG));
    }

    /**
     * This method scans the user input.
     * @return String
     */
    static String readInput() {
        String in = "";
        try (Scanner scanner = new Scanner(System.in)) {
            in = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return in;
    }

    /**
     * The method removes the white spaces and breaks given string against given expression (-)
     * @param input
     * @return If param string meets condition, Optional<String> returns. Otherwise, empty Optional
     */
    static Optional<String> validateInput(String input) {
        var strArr = input.replaceAll("\\s+", "").split("-");

        if (strArr.length == 2) {
            var scoreTeam1 = Integer.parseInt(String.valueOf(strArr[0].charAt(strArr[0].length() - 1)));
            var nameTeam1 = new StringBuilder(strArr[0]).delete(strArr[0].length() - 1, strArr[0].length()).toString();

            var scoreTeam2 = Integer.parseInt(String.valueOf(strArr[1].charAt(0)));
            var nameTeam2 = new StringBuilder(strArr[1]).deleteCharAt(0).toString();

            return Optional.of(nameTeam1 + " " + scoreTeam1 + " - " + scoreTeam2 + " " + nameTeam2);
        }
        return Optional.empty();
    }

    /**
     * In Java 11, we can use the new API named Files.writeString to write a String or text directly toa file.
     * @param path
     * @param content
     */
    static void writeFile(Path path, String content) {
        //if file doesn't exist, create and write it. If file exists, override the content. default utf_8
        try {
            Files.writeString(path, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}