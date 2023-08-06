package com.example.music.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDTO {
    private Integer id;
    private String namePlaylist;
    private LocalDate releaseDate;
    private String image;
    private String describePlaylist;
}
