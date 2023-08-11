package com.sixtofly.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;

/**
 * 程序中不调用获取连接，只监听端口
 * 对于连接数，每个进程不是共享一个总参数，而是通过系统参数 somaxconn 或者程序中指定 backlog 参数，取其中的较小值
 * 分别设置连接参数。实际连接数大小是设置数 +1 。系统最大连接数还需要跟系统最大文件描述符和其他系统资源联系起来。
 * @author xie yuan bing
 * @date 2021-08-16 09:10
 */
public class NotAcceptServerSocketTest {

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            throw new RuntimeException("请传入启动参数, 第一个参数是监听端口， 第二个参数是 backlog");
        }

        int port = Integer.parseInt(args[0]);
        int backlog = Integer.parseInt(args[1]);

        /**
         * backlog 全连接队列大小
         * 该参数与系统参数 somaxconn 中取最小值
         */
        ServerSocket serverSocket = new ServerSocket(port, backlog);
        // 服务器只监听端口上的连接，不调用 accept() 方法读取连接到应用中处理
//        serverSocket.accept();

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
