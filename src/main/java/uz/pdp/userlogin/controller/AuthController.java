package uz.pdp.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.userlogin.payload.ReqLogin;
import uz.pdp.userlogin.payload.ReqRegister;
import uz.pdp.userlogin.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public HttpEntity<?>login(@RequestBody ReqLogin reqLogin) {
        boolean login = authService.login(reqLogin);
        if (login){
            return ResponseEntity.ok("Entry");
        }
        return ResponseEntity.status(401).body("Error");
    }

    @PostMapping("/register")
    public HttpEntity<?>signup(@RequestBody ReqRegister reqRegister) {
        boolean register = authService.register(reqRegister);
        if(register){
            return ResponseEntity.ok("Registration");

        }
        return ResponseEntity.status(409).body("Registration Error");
    }


}
