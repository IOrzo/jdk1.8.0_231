package com.sixtofly.nio;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author xie yuan bing
 * @date 2021-07-09 09:00
 */
public class ServerSocketTest {

    /**
     * jdk8 编译运行, 开启了三个客户端， 一次性发送信息如下，对应的系统调用流程在 bio.29991 文件中 (有删减)
     * jdk8 bio 中使用了多路复用器 poll
     * client send:hello
     * client send:1
     * client send:2
     * client send:3
     * client send:quit
     * client send:4
     * client send:5
     * client send:6
     * client send:quit
     * client send:7
     * client send:8
     * client send:9
     * client send:quit
     *
     * jdk5 编译运行，对应系统调用流程在 jdk5.31985 文件中
     * jdk5 bio 中就直接调用的 accept
     * client send:hello
     * client send:1
     * client send:2
     * client send:3
     * client send:quit
     * client send:2
     * client send:3
     * client send:4
     * client send:quit
     * client send:5
     * client send:6
     * client send:7
     * client send:quit
     */
    public static void main(String[] args) throws IOException {

        /**
         * 当应用程序只执行这句时，内核则会监听该端口
         * 内核调用过程查看 bind.983
         */
        ServerSocket serverSocket = new ServerSocket(9110);

        /**
         * 第二个连接依然会连接上，只是服务端不能及时处理收到的信息
         * 个人猜测: 程序上数据没有处理，但是内核已经创建了连接，并且也接收到客户端发来的信息。等待程序处理
         */
        while (true) {

            /**
             * 调用 accept 时，会调用内核 accept 函数，从连接队列中获取一个连接
             */
            Socket client = serverSocket.accept();
            Scanner scanner = new Scanner(client.getInputStream());
            while (scanner.hasNext()) {
                String send = scanner.next();
                System.out.println("client send:" + send);
                if ("quit".equals(send)) {
                    scanner.close();
                    client.close();
                    break;
                }
                OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
                writer.write("success");
                writer.flush();
            }
        }
    }
}
