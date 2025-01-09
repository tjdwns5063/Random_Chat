package org.seongjki.command.msg;

import java.util.Objects;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;

public class MessageArgs implements CommandArg {

    private String type;

    private String channelName;

    private String msg;

    private Long requesterId;

    public MessageArgs(String type, Long requesterId, String channelName, String msg) {
        this.type = type;
        this.channelName = channelName;
        this.msg = msg;
        this.requesterId = requesterId;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getMsg() {
        return msg;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "MessageArgs{" +
                "type='" + type + '\'' +
                ", channelName='" + channelName + '\'' +
                ", msg='" + msg + '\'' +
                ", requesterId=" + requesterId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageArgs that = (MessageArgs) o;
        return Objects.equals(type, that.type) && Objects.equals(channelName, that.channelName) && Objects.equals(msg, that.msg) && Objects.equals(requesterId, that.requesterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, channelName, msg, requesterId);
    }
}
