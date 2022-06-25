/**
 * Note: Clean the text file content at every run!
 * url for text file -> "./question2/src/main/resources/gameScores.txt"
 */
public class Main {
    private static volatile boolean isFileEmpty = true;

    public static void main(String[] args) {
        run();
    }
    public static void run() {
        Thread writer = new Thread(ProducerApp::init);
        Thread reader = new Thread(ConsumerApp::init);
        while (isFileEmpty) {
            writer.start();
            updateFileStatus();
        }
        reader.start();
    }

    /**
     * To stop Java thread via Volatile Flat
     */
    public static void updateFileStatus() {
        isFileEmpty = false;
    }

}