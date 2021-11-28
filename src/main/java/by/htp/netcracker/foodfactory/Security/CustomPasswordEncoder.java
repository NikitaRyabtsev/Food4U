package by.htp.netcracker.foodfactory.Security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return BCrypt.hashpw(charSequence.toString(), BCrypt.gensalt(8));
    }

    @Override
    public boolean matches(CharSequence charSequence, String passwordInDatabase) {
        return BCrypt.checkpw(charSequence.toString(),passwordInDatabase);
    }
}
