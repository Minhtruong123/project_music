package com.example.music.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_song", columnDefinition = "varchar(45)")
    private String nameSong;
    @Column(name = "release_date", columnDefinition = "date")
    private LocalDate releaseDate;
    @Column(name = "image", columnDefinition = "varchar(255)")
    private String image;
    @Column(name = "length_song", columnDefinition = "varchar(10)")
    private String lengthSong;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonManagedReference
    private TypeSong typeSong;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonManagedReference
    private Album album;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_list",
            joinColumns = @JoinColumn(name = "id_song"),
            inverseJoinColumns = @JoinColumn(name = "id_author"))
    private Set<Author> authorSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "singer_list",
            joinColumns = @JoinColumn(name = "id_song"),
            inverseJoinColumns = @JoinColumn(name = "id_singer"))
    private Set<Singer> singerSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "playlist_detail",
            joinColumns = @JoinColumn(name = "id_song"),
            inverseJoinColumns = @JoinColumn(name = "id_playlist"))
    private Set<Playlist> playlistSet;
}