package net.tianzx.myapplication.net.tianzx.myapplication.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tianzx on 2016/3/14.
 */
public class MyServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(8888);
            client =  server.accept();
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            byte bs[] = new byte[1024];
            in.read(bs);
            String str = new String(bs);
            System.err.println("收到的数据"+str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}