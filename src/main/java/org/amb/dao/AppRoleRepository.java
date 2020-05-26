package org.amb.dao;

import org.amb.entities.Roles_utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<Roles_utilisateur, Long> {
    public Roles_utilisateur findByRoleName(String rolename) ;
}
