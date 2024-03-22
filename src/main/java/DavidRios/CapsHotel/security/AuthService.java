package DavidRios.CapsHotel.security;

import DavidRios.CapsHotel.DTOs.LoginUser;
import DavidRios.CapsHotel.DTOs.NewUser;
import DavidRios.CapsHotel.entities.User;
import DavidRios.CapsHotel.exceptions.BadRequestException;
import DavidRios.CapsHotel.exceptions.UnauthorizedException;
import DavidRios.CapsHotel.repositories.UserRepo;
import DavidRios.CapsHotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private JwtTools jwtTools;

    public String authentication(LoginUser loginUser) {

        User user = userService.findByEmail(loginUser.email());
        if (bcrypt.matches(loginUser.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Wrong credentials!");
        }
    }

    public User saveUser(NewUser newUser) {
        userRepository.findByEmail(newUser.email()).ifPresent(user -> {
            throw new BadRequestException("The following email address exists already: " + user.getEmail());
        });
        User userToSave = new User(newUser.name(), newUser.surname(), newUser.email(), bcrypt.encode(newUser.password()));

        return userRepository.save(userToSave);
    }
}
