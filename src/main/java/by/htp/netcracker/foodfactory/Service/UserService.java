package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registration(User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setSex(user.getSex());
        newUser.setBlock(user.getBlock());
        newUser.setRole(user.getRole());
        return userRepository.save(newUser);

    }
}
