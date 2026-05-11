package com.back.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(String username, String nickname, String password) {
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        userRepository.save(user);
    }
}
