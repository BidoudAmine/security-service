package org.amb.service;

import org.amb.entities.Roles_utilisateur;
import org.amb.entities.Utilisateur;

public interface AccountService {
    public Utilisateur saveUser(String username , String password , String confirmedPassword) ;
    public Roles_utilisateur save(Roles_utilisateur role) ;
    public Utilisateur loadUserByUsername(String username) ;
    public  void addRoleToUser(String username , String rolename) ;

}
