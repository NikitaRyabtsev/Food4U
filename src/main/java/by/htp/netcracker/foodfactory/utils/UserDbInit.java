//package by.htp.netcracker.foodfactory.utils;
//
//import by.htp.netcracker.foodfactory.Model.User;
//import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//@Service
//public class UserDbInit implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserDbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) {
//        // Delete all
//        this.userRepository.deleteAll();
//
//        // Crete users
//        User user = new User("USER", "Никита", "user12345", passwordEncoder.encode("user12345"), "123nikita123@mail.ru",
//                "Рябцев", " Мужчина", "UNBLOCK");
//        User admin = new User("ADMIN", "Артём", "admin12345", passwordEncoder.encode("admin12345"), "123admin123@mail.ru",
//                "Рябцев", " Мужчина", "UNBLOCK");
//
//        List<User> users = Arrays.asList(user, admin);
//        // Save to db
//        this.userRepository.saveAll(users);
//
//    }
//}
