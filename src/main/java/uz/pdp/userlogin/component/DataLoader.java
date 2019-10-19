package uz.pdp.userlogin.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.userlogin.entity.User;
import uz.pdp.userlogin.repository.RoleRepository;
import uz.pdp.userlogin.repository.UserRepository;
import uz.pdp.userlogin.entity.User;
import uz.pdp.userlogin.repository.RoleRepository;
import uz.pdp.userlogin.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
      if (initialMode.equals("always")){
          userRepository.save(
                  new User(
                          "Dan",
                          "Watson",
                          "+513646656542",
                          "dan",
                          "daniel@kjhkhkj",
                          passwordEncoder.encode("12345"),
                          roleRepository.findAll()
                  )
          );
      }
    }
}
