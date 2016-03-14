package net.tianzx.myapplication.net.tianzx.myapplication.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by tianzx on 2016/3/14.
 */
public class MyClient {

    public static void main(String []args) {
        try {
            Socket server = new Socket("192.168.199.1",8888);
            InputStream in = server.getInputStream();
            OutputStream out = server.getOutputStream();

            String str = "client send ";
            out.write(str.getBytes());
            out.flush();

            byte bs[] = new byte[1024];
            in.read(bs);
            System.err.println(new String(bs));

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
