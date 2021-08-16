package an.sixtofly.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 简单的客户端
 * @author xie yuan bing
 * @date 2021-08-16 09:44
 */
public class SimpleSocketClientTest {

    public static void main(String[] args) {

        Socket socket = new Socket();
        try {
            // 设置自己服务器的 ip 地址和端口
            socket.connect(new InetSocketAddress("47.93.239.109", 9130));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            try {
                socket.getOutputStream().write(s.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
