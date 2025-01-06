package org.seongjki.user.storage;

import java.util.List;
import java.util.Optional;
import org.seongjki.user.User;

public interface UserRepository {

    List<User> findAll();

    User save(User user);

    Optional<User> findById(Long id);

}
