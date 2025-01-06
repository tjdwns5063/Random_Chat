package org.seongjki.user.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.seongjki.user.User;

public class MemoryUserRepository implements UserRepository {

    private static List<User> users = new ArrayList<User>();

    @Override
    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public User save(User user) {
        user.setId((long) users.size());
        users.add(user);

        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

}
