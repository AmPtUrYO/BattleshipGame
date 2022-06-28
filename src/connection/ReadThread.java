package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadThread extends Thread{
    private final ReadThreadListener listener;
    private final InputStream is;
    private final BufferedReader br;

    ReadThread(InputStream is, ReadThreadListener listener) {
        this.is = is;
        this.listener = listener;
        this.br = new BufferedReader(new InputStreamReader(this.is));
    }

    public void run() {
        try {
            while(true) {
                String message = this.br.readLine();
                this.listener.recognizedMessage(message);
            }
        } catch (IOException e) {
            System.err.println("connection broken: " + e.getLocalizedMessage());
            this.listener.connectionClosed();
        }
    }
}
