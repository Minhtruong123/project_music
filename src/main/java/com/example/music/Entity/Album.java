package com.example.music.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_album", columnDefinition = "varchar(45)")
    private String nameAlbum;
    @Column(name = "release_date", columnDefinition = "date")
    private LocalDate releaseDate;
    @Column(name = "image", columnDefinition = "varchar(255)")
    private String image;
    @Column(name = "describe_album", columnDefinition = "mediumtext")
    private String describeAlbum;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Song> songSet;
}
