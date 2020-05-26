package org.amb.dao;

import org.amb.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<Utilisateur, Long> {
    public Utilisateur findByUsername(String username) ;
}
