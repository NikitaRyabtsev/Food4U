package by.htp.netcracker.foodfactory.Security;


import by.htp.netcracker.foodfactory.Model.User;
import by.htp.netcracker.foodfactory.Reposotories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserPrincipalDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: "+ username);
        }
        return new UserPrincipal(user);
    }


}
