package com.innopolis.testproject.services;

import com.innopolis.testproject.domain.Role;
import com.innopolis.testproject.domain.User;
import com.innopolis.testproject.domain.UserDetailsImpl;
import com.innopolis.testproject.repos.RoleRepo;
import com.innopolis.testproject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    public User addUser(User user){
        Role role = roleRepo.findByName("ROLE_USER");
        if (role == null) {
            role = new Role(1L, "ROLE_USER");
        }
        user.setRoles(Collections.singleton(role));
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return new UserDetailsImpl(user);
        }
        return null;
    }
}
