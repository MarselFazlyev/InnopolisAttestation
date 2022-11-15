package com.innopolis.testproject.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pgrole")
@Getter
@Setter
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(Long id, String name) {
        setId(id);
        setName(name);
    }

    public void addUser(User user){
        users.add(user);
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
