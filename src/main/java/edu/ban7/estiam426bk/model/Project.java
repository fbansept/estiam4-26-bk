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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String name;

    @ManyToOne(optional = false)
    @JsonIgnore
    protected AppUser owner;

    @ManyToMany
    @JoinTable(
            name = "tag_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    protected List<Tag> tags = new ArrayList<>();

}
