package connection;

public interface ReadThreadListener {
    /**
     * Tell listener message received
     * @param message
     */
    void recognizedMessage(String message);

    /**
     * Tell listener: connection closed
     */
    void connectionClosed();
}
