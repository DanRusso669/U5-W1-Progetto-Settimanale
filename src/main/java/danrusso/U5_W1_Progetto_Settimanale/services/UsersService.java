package danrusso.U5_W1_Progetto_Settimanale.services;

import danrusso.U5_W1_Progetto_Settimanale.entities.User;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.NotFoundException;
import danrusso.U5_W1_Progetto_Settimanale.exceptions.ValidationException;
import danrusso.U5_W1_Progetto_Settimanale.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public User findByUsername(String username) {
        User found = usersRepository.findByUsername(username);
        if (found == null) throw new NotFoundException("User with username " + username + " not found.");
        return found;
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public void saveUser(String username, String fullname, String email) {

        if (usersRepository.findByUsername(username) != null)
            throw new ValidationException("Username " + username + " is already in use.");

        if (usersRepository.existsByEmail(email))
            throw new ValidationException("Email " + email + " already in use.");

        User newUser = new User(username, fullname, email);

        usersRepository.save(newUser);

        System.out.println("User " + username + " addedd successfully.");
    }
}
