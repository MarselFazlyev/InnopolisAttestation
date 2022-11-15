package com.innopolis.testproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pgticket")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private boolean isSold;

    @ManyToOne(fetch = FetchType.LAZY)
    private Program program;
}
