package net.eventstore.client.message;

import net.eventstore.client.tcp.TcpCommand;
import net.eventstore.client.tcp.TcpPackage;

/**
 * ExceptionMessage
 *
 * @author Stasys
 */
public class ExceptionMessage extends Exception {

    private final TcpCommand command;
    private final String message;

    /**
     * Constructor with mandatory data.
     * 
     * @param command
     * @param message
     */
    public ExceptionMessage(TcpCommand command, String message) {
        super();
        this.command = command;
        this.message = message;
    }

    public ExceptionMessage(TcpPackage pckg) {
        this.command = pckg.getCommand();
        this.message = new String(pckg.getData());
    }

    /**
     * @return the command
     */
    public TcpCommand getCommand() {
        return command;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
