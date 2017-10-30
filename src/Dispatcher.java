import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Dispatcher {
    private static ExecutorService executeIt = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3000)) {
            while (true) {
                Socket client = server.accept();
                executeIt.execute(new EchoServer(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
