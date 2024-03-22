package DavidRios.CapsHotel.security;


import DavidRios.CapsHotel.DTOs.LoginToken;
import DavidRios.CapsHotel.DTOs.LoginUser;
import DavidRios.CapsHotel.DTOs.NewUser;
import DavidRios.CapsHotel.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public LoginToken login(@RequestBody LoginUser loginUser) {
        return new LoginToken(authService.authentication(loginUser));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody NewUser newUser) {
        return this.authService.saveUser(newUser);
    }
}
