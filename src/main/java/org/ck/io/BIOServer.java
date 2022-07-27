package org.ck.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TCP协议Socket使用BIO进行通信：服务端
public class BIOServer {
    // 在main线程中执行下面这些代码
    public static void main(String[] args) {
//使用Socket进行网络通信
        ServerSocket server = null;
//基于字节流
        try {
            server = new ServerSocket(8000);
            System.out.println("服务端启动成功，监听端口为8000，等待客户端连接...");
            while (true) {
                Socket socket = server.accept(); //等待客户端连接
                System.out.println("客户连接成功，客户信息为：" +
                        socket.getRemoteSocketAddress());
                //创建多线程
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream in = socket.getInputStream();
                            byte[] buffer = new byte[1024];
                            int len = 0;
//读取客户端的数据
                            while ((len = in.read(buffer)) > 0) {
                                System.out.println(new String(buffer, 0, len));
                            }
                            //向客户端写数据
                            OutputStream out = socket.getOutputStream();
                            out.write("hello!".getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}