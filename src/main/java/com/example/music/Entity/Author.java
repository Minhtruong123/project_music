package com.example.music.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_author", columnDefinition = "varchar(45)")
    private String nameAuthor;
    @Column(name = "nationality", columnDefinition = "varchar(45)")
    private String nationality;
    @Column(name = "date_of_birth", columnDefinition = "date")
    private LocalDate dateOfBirth;
    @Column(name = "gender", columnDefinition = "varchar(10)")
    private String gender;
    @Column(name = "image", columnDefinition = "varchar(255)")
    private String image;
    @Column(name = "describe_author", columnDefinition = "mediumtext")
    private String describeAuthor;
//    @ManyToMany(mappedBy = "authorSet")
//    private Set<Song> songs;
}