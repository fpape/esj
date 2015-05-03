package net.eventstore.client.message;

import net.eventstore.client.model.Message;
import net.eventstore.client.model.ParseException;
import net.eventstore.client.tcp.TcpCommand;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * WriteEventsCompleted
 *
 * @author Stasys
 */
public class WriteEventsCompleted extends Message {

    private int firstEventNumber;
    private int lastEventNumber;
    protected ClientMessageDtos.OperationResult result;

    public WriteEventsCompleted() {
        super(TcpCommand.WriteEventsCompleted);
    }

    @Override
    public void parse(byte[] data) throws ParseException {
        try {
            ClientMessageDtos.WriteEventsCompleted dto = ClientMessageDtos.WriteEventsCompleted.parseFrom(data);
            this.result = dto.getResult();
            this.firstEventNumber = dto.getFirstEventNumber();
            this.lastEventNumber = dto.getLastEventNumber();
            this.message = dto.getMessage();
        } catch (InvalidProtocolBufferException ex) {
            throw new ParseException(ex);
        }
    }

    @Override
    protected String toResultInfo() {
        return String.format("Received (%s): %s", this.getResult(), this.getMessage());
    }

    /**
     * @return the firstEventNumber
     */
    public int getFirstEventNumber() {
        return firstEventNumber;
    }

    /**
     * @return the lastEventNumber
     */
    public int getLastEventNumber() {
        return lastEventNumber;
    }

    /**
     * @return the result
     */
    public ClientMessageDtos.OperationResult getResult() {
        return result;
    }

}
