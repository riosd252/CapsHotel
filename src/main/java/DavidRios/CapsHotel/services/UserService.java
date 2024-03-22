package DavidRios.CapsHotel.services;

import DavidRios.CapsHotel.entities.User;
import DavidRios.CapsHotel.exceptions.NotFoundException;
import DavidRios.CapsHotel.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;


    public Page<User> getUsers(int pageNumber, int size, String orderBy) {
        if (size > 5) size = 5;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return userRepository.findAll(pageable);
    }


    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User n. " + id + " not found."));
    }

    public User findByEmail(String email) { return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User with " + email + " not found."));}

    public User update(UUID id, User modifiedUser) {
        User found = this.findById(id);
        found.setName(modifiedUser.getName());
        found.setSurname(modifiedUser.getSurname());
        found.setEmail(modifiedUser.getEmail());
        found.setPassword(modifiedUser.getPassword());
        return userRepository.save(found);
    }

    public void delete(UUID id) {
        User found = this.findById(id);
        userRepository.delete(found);
    }

}
