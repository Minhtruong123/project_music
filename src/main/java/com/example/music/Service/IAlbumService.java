package com.example.music.Service;

import com.example.music.DTO.AlbumDTO;
import com.example.music.Entity.Album;

import java.util.List;

public interface IAlbumService {
    List<AlbumDTO> findAllAlbum(String search);
    Album findAlbumById(int id);
    void addAlbum(AlbumDTO albumDTO);
    void deleteAlbum(Album album);
}
