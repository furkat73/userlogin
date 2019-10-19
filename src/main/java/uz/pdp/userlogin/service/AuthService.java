package uz.pdp.userlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.userlogin.entity.User;
import uz.pdp.userlogin.payload.ReqLogin;
import uz.pdp.userlogin.payload.ReqRegister;
import uz.pdp.userlogin.repository.UserRepository;

@Service
public class AuthService  {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public boolean login(ReqLogin reqLogin){
        if(userRepository.existsUserByUsername(reqLogin.getUsername())){
           if(passwordEncoder.matches(reqLogin.getPassword(),userRepository.getUserByUsername(reqLogin.getUsername()).getPassword())){
               return true;
           }
        }
        return false;
    }


    public boolean register(ReqRegister reqRegister){
        if(!userRepository.existsUserByUsername(reqRegister.getUsername())){
            User user=new User();
            user.setFirstName(reqRegister.getFirstName());
            user.setLastName(reqRegister.getLastName());
            user.setUsername(reqRegister.getUsername());
            user.setPassword(passwordEncoder.encode(reqRegister.getPassword()));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
