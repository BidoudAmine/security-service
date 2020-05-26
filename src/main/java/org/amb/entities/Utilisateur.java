package org.amb.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)  //username unique ..
    private String username ;
    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    private String password ;
    private boolean actived ;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles_utilisateur> roles = new ArrayList<>() ;
}

//EAGER :::
//c-a-d a chaque fois qu on demande a JPA de charger in user , il charge automatiquement les roles de ce user ..