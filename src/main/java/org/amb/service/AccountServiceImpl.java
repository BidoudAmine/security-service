package org.amb.service;

import org.amb.entities.Roles_utilisateur;
import org.amb.entities.Utilisateur;
import org.amb.dao.AppRoleRepository;
import org.amb.dao.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional  //c-à-d y a pas de quoi ajouter a chaque reprise le truc save en fin de tte operation .. ca s fait automatiqmnt ! par JPA
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository appUserRepository ;
    @Autowired
    private AppRoleRepository appRoleRepository ;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder ;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }// Ce constructeur sert à instancier la classe AccountServiceImpl au demarage de l application

    @Override
    public Utilisateur saveUser(String username, String password, String confirmedPassword) {
        Utilisateur user = appUserRepository.findByUsername(username) ;
        if (user!=null) throw new RuntimeException("This user does already exists !") ;
        if (!password.equals(confirmedPassword)) throw new RuntimeException("The confirmation password is not correct, try again .") ;
        Utilisateur utilisateur = new Utilisateur() ;
        utilisateur.setUsername(username);
        utilisateur.setPassword(bCryptPasswordEncoder.encode(password));  //pour l enregistrer ds la BD d une manière cryptée
        utilisateur.setActived(true);
        appUserRepository.save(utilisateur) ;
        addRoleToUser(username , "USER");
        return utilisateur;
    }

    @Override
    public Roles_utilisateur save(Roles_utilisateur role) {
        return appRoleRepository.save(role);
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        Utilisateur utilisateur = appUserRepository.findByUsername(username) ;
        Roles_utilisateur rolesutilisateur = appRoleRepository.findByRoleName(rolename) ;
        utilisateur.getRoles().add(rolesutilisateur) ;

    }
}
