package com.innopolis.testproject.repos;

import com.innopolis.testproject.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepo extends JpaRepository<Program, Long> {
    /*
    Create
    Retrive
    Update
    Delete
     */

    Program findByName(String name);
    //"SELECT * FROM pghumans WHERE NAME = ?"
}
