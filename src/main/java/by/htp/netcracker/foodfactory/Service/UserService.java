package by.htp.netcracker.foodfactory.Service;

import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import by.htp.netcracker.foodfactory.Security.CustomPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CustomPasswordEncoder customPasswordEncoder;

    public UserService(UserRepository userRepository, CustomPasswordEncoder customPasswordEncoder) {
        this.userRepository = userRepository;
        this.customPasswordEncoder = customPasswordEncoder;
    }

    public User registration(User user){
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setPassword(customPasswordEncoder.encode(user.getPassword()));
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
