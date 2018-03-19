package com.example.lactoriaus.wowweeremote;


import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    String dstPort;
    String messageToSend;

    TcpClient(String addr, String port, String msg) {
        dstAddress = addr;
        dstPort = port;
        messageToSend = msg;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Socket socket = null;

        try {
            socket = new Socket(dstAddress, Integer.parseInt(dstPort));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            printWriter.write(messageToSend);
            printWriter.close();
            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
