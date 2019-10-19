package uz.pdp.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.userlogin.entity.User;
import uz.pdp.userlogin.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsUserByUsername(String username);

    User getUserByUsername(String username);
}
