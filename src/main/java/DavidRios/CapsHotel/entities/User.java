package DavidRios.CapsHotel.entities;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String surname;
    private String emaill;
    private String password;
    private String avatar;

    public User(String name, String surname, String emaill, String password) {
        this.name = name;
        this.surname = surname;
        this.emaill = emaill;
        this.password = password;
    }
}
