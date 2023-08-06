package com.example.music.Mapper;

import com.example.music.DTO.SongDTO;
import com.example.music.Entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISongMapper {
    SongDTO songToSongDTO(Song song);
    Song songDTOToSong(SongDTO songDTO);
}
