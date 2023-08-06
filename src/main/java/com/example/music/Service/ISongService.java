package com.example.music.Service;

import com.example.music.DTO.SongDTO;
import com.example.music.Entity.Song;

import java.util.List;

public interface ISongService {
    List<SongDTO> findAllSong(String search);
    Song findSongById(int id);
    void addSong(SongDTO songDTO);
}
