package com.example.music.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
    private Integer id;
    private String nameAlbum;
    private LocalDate releaseDate;
    private String image;
    private String describeAlbum;
}
