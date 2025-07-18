package danrusso.U5_W1_Progetto_Settimanale;

import danrusso.U5_W1_Progetto_Settimanale.entities.User;
import danrusso.U5_W1_Progetto_Settimanale.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private UsersService usersService;

    @Override
    public void run(String... args) throws Exception {

        User yotobi = new User("Yotobi", "Karim Musa", "yotobi@gmail.com");

        usersService.saveUser(yotobi);
    }
}
