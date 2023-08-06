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
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_playlist", columnDefinition = "varchar(45)")
    private String namePlaylist;
    @Column(name = "release_date", columnDefinition = "date")
    private LocalDate releaseDate;
    @Column(name = "image", columnDefinition = "varchar(255)")
    private String image;
    @Column(name = "describe_playlist", columnDefinition = "mediumtext")
    private String describePlaylist;
//    @ManyToMany(mappedBy = "playlistSet")
//    private Set<Song> songs;
}
