package com.example.music.Mapper;

import com.example.music.DTO.TypeSongDTO;
import com.example.music.Entity.TypeSong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITypeSongMapper {
    TypeSongDTO typeSongToTypeSongDTO(TypeSong typeSong);
    TypeSong typeSongDTOToTypeSong(TypeSongDTO typeSongDTO);
}
