package com.example.music.Service;

import com.example.music.DTO.TypeSongDTO;
import com.example.music.Entity.TypeSong;

import java.util.List;

public interface ITypeSongService {
    List<TypeSongDTO> listAllTypeSongDTO(String search);
    TypeSong findTypeSongById(int id);
    void addTypeSong(TypeSongDTO typeSongDTO);
    void deleteTypeSong(TypeSong typeSong);
}
