package edu.ban7.estiam426bk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String email;

    @JsonIgnore
    protected String password;

    @ManyToOne(optional = false)
    protected Role role;

    @OneToMany(mappedBy = "owner")
    protected List<Project> projects = new ArrayList<>();
}
