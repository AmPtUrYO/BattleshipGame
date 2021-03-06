package connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Connection implements ReadThreadListener{
    private InputStream is;
    private OutputStream os;
    private String message;

    public void streamCreated(TCPStream channel) {
        try {
            synchronized(this) {
                this.is = channel.getInputStream();
                this.os = channel.getOutputStream();
            }
            // run ReadThread
            new ReadThread(this.is, this).start();
        } catch (IOException e) {
            System.err.println("fatal: " + e.getLocalizedMessage());
            System.exit(1);
        }
    }

    public void sendMessage(String message) {
        try {
            //this.os.write(messageByte);
            PrintWriter writer = new PrintWriter(os, true);
            writer.println(message);
        } catch (Exception e) {
            System.err.println("fatal: cannot send message: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void recognizedMessage(String message) {
        System.out.println(message);
        this.message = message;
    }

    @Override
    public void connectionClosed() {
        this.is = null; this.os = null;
    }

    public String getLastMessage(){
        return message;
    }
}
