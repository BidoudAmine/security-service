
package org.amb.web;

import lombok.Data;
import org.amb.entities.Utilisateur;
import org.amb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  UserController {
    @Autowired
    private AccountService accountService ;
    @PostMapping("/register")
    public Utilisateur register(@RequestBody UserForm userForm){
        return accountService.saveUser(userForm.getUsername() , userForm.getPassword() , userForm.getConfirmedPassword()) ;
    }
}

@Data
class UserForm {
    //private String nom ;
   // private String prenom ;
    private String username ;
    private String password ;
    private String confirmedPassword ;
}


