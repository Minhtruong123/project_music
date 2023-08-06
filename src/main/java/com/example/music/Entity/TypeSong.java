package com.example.music.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class TypeSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_name", columnDefinition = "varchar(45)")
    private String typeName;
    @OneToMany(mappedBy = "typeSong", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Song> songSet;
}