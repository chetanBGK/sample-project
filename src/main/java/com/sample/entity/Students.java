package com.sample.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollno;
    @Size(max = 20)
    @NotBlank(message = "Nme should not be blanks")
    private String name;

    @ManyToOne
    @JoinColumn(name = "branchid")
    private Branch branch;

}
