package Koon.sDiary.server.repository;

import Koon.sDiary.server.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String userId);
    Optional<User> findBynickName(String nickName);
    List<User> findAll();

}
