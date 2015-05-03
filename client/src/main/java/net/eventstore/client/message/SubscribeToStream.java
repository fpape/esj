package net.eventstore.client.message;

import net.eventstore.client.Settings;
import net.eventstore.client.model.Message;
import net.eventstore.client.model.UserCredentials;
import net.eventstore.client.tcp.TcpCommand;

import com.google.protobuf.GeneratedMessage;

/**
 * WriteEvents
 *
 * @author Stasys
 */
public class SubscribeToStream extends Message {

    private final String streamId;
    private static boolean resolveLinkTos = false;

    public SubscribeToStream(String streamId) {
        this(streamId, null);
    }

    public SubscribeToStream(String streamId, UserCredentials user) {
        super(TcpCommand.SubscribeToStream, user);
        this.streamId = streamId;
    }

    @Override
    public GeneratedMessage getDto(Settings settings) {
        ClientMessageDtos.SubscribeToStream.Builder web = ClientMessageDtos.SubscribeToStream.newBuilder();
        web.setEventStreamId(streamId);
        web.setResolveLinkTos(resolveLinkTos);

        return web.build();
    }

    /**
     * @return the streamId
     */
    public String getStreamId() {
        return streamId;
    }

    /**
     * @return the resolveLinkTos
     */
    public static boolean isResolveLinkTos() {
        return resolveLinkTos;
    }

}
