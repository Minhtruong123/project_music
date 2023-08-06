package com.example.music.Service.Impl;

import com.example.music.DTO.AlbumDTO;
import com.example.music.Entity.Album;
import com.example.music.Exception.NotFoundException;
import com.example.music.Mapper.IAlbumMapper;
import com.example.music.Repository.IAlbumRepository;
import com.example.music.Service.IAlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlbumService implements IAlbumService {
    private final IAlbumRepository albumRepository;
    private final IAlbumMapper albumMapper;

    @Override
    public List<AlbumDTO> findAllAlbum(String search) {
        return albumRepository.findAlbumByNameAlbumIsContaining(search).stream().map(albumMapper::albumToAlbumDTO).collect(Collectors.toList());
    }

    @Override
    public Album findAlbumById(int id) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album == null){
            throw new NotFoundException(String.format("Not found request application by id %d", id));
        }
        return album;
    }

    @Override
    public void addAlbum(AlbumDTO albumDTO) {
        Album album = albumMapper.albumDTOToAlbum(albumDTO);
        albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Album album) {
        albumRepository.delete(album);
    }
}
