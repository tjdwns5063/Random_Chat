package org.seongjki.channel.storage;

import java.util.List;
import java.util.Optional;
import org.seongjki.channel.Channel;

public interface ChannelRepository {

    Channel save(Channel ch);

    List<Channel> findAll();

    Optional<Channel> findById(Long id);

    Optional<Channel> findByName(String name);

    boolean isPresentByName(String name);

}
