package com.innopolis.testproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pgprogram")
@Getter
@Setter
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
    private List<Program> program = new ArrayList<>();
}
