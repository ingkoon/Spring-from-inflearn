package Koon.sDiary.server.service;


import Koon.sDiary.server.domain.User;
import Koon.sDiary.server.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;
    public String save;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(User user){
        validateDuplicateUser(user);

        userRepository.save(user);
        return user.getUserId();

    }

    private void validateDuplicateUser(User user){
        userRepository.findById(user.getUserId()).ifPresent(m->{throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    public List<User> findUsers() { return userRepository.findAll();}
    public Optional<User> findOne(String userId) {return userRepository.findById(userId);}
}
