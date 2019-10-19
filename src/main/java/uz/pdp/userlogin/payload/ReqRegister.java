package uz.pdp.userlogin.payload;

import lombok.Data;

@Data
public class ReqRegister {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
