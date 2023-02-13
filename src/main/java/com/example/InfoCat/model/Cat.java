package com.example.InfoCat.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;

@Entity
@Table(name = "cats")
@Data
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fact")
    @Size(min = 2, max = 2000, message = "Fact should not be between 2 and 2000 characters")
    private String fact;

    @Column(name = "length")
    private double length;
}
