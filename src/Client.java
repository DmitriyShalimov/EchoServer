import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);
        byte[] array = new byte[16];
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine() + "\n";
            outputStream.write(str.getBytes());
            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            inputStream.read(array);
            System.out.println(new String(array));
        }
    }
}
