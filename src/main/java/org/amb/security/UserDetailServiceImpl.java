package org.amb.security;

import org.amb.entities.Utilisateur;
import org.amb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = accountService.loadUserByUsername(username) ;
        if(utilisateur == null) throw  new UsernameNotFoundException("Invalid User") ;
        Collection<GrantedAuthority> authorities = new ArrayList<>() ;
        utilisateur.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName())) ;
        });
        return new User(utilisateur.getUsername() , utilisateur.getPassword() , authorities);
    }
}
