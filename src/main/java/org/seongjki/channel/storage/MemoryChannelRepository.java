package org.seongjki.channel.storage;

import java.util.*;
import org.seongjki.channel.Channel;

public class MemoryChannelRepository implements ChannelRepository {

    private List<Channel> channels = new ArrayList<>();

    @Override
    public Channel save(Channel ch) {

        ch.setId((long)channels.size());
        channels.add(ch);

        return ch;
    }

    @Override
    public List<Channel> findAll() {
        return Collections.unmodifiableList(channels);
    }

    @Override
    public Optional<Channel> findById(Long id) {
        return channels.stream().filter(ch -> Objects.equals(ch.getId(), id)).findFirst();
    }

    @Override
    public Optional<Channel> findByName(String name) {
        return channels.stream().filter(ch -> Objects.equals(ch.getName(), name)).findFirst();
    }
}
