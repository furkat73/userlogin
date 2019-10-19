package uz.pdp.userlogin.payload;

import lombok.Data;

@Data
public class ReqLogin {
    private String username;
    private String password;
}
