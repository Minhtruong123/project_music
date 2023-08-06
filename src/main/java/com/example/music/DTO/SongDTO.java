package com.example.music.DTO;

import com.example.music.Entity.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private Integer id;
    private String nameSong;
    private LocalDate releaseDate;
    private String image;
    private String lengthSong;
    private TypeSong typeSong;
    private Album album;
    private Set<Author> authorSet;
    private Set<Singer> singerSet;
    private Set<Playlist> playlistSet;
}
