public class Main {
    private static volatile boolean isFileEmpty = true;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        while (isFileEmpty) {
            Thread writer = new Thread(ProducerApp::init);
            writer.start();
            updateFileStatus();
        }
        Thread reader = new Thread(ConsumerApp::init);
        reader.start();
    }

    /**
     * To stop Java thread via Volatile Flat
     */
    public static void updateFileStatus() {
        isFileEmpty = false;
    }

}