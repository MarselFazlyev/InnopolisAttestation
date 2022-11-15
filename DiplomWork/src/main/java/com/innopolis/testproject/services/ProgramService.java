package com.innopolis.testproject.services;

import com.innopolis.testproject.domain.Program;
import com.innopolis.testproject.repos.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepo programRepo;

    public Program saveProgram(Program program){
        return programRepo.save(program);
    }

    public List<Program> getAll(){
        return programRepo.findAll();
    }

    public Program getById(Long id){
        return programRepo.findById(id).orElse(null);
    }
}
