package com.innopolis.testproject.repos;

import com.innopolis.testproject.domain.Program;
import com.innopolis.testproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
