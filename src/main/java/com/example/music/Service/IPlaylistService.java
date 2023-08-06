package com.example.music.Service;

import com.example.music.DTO.PlaylistDTO;
import com.example.music.Entity.Playlist;

import java.util.List;

public interface IPlaylistService {
    List<PlaylistDTO> findAllPlaylistDTO(String search);
    Playlist findPlayListById(int id);
    void addPlaylist(PlaylistDTO playlistDTO);
    void deletePlaylist(Playlist playlist);
}
