package connection;

public interface ReadThreadListener {
    /**
     * Tell listener message received
     * @param message
     */
    void recognizedMessage(byte message);

    /**
     * Tell listener: connection closed
     */
    void connectionClosed();
}
