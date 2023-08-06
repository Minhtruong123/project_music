package com.example.music.Service.Impl;

import com.example.music.DTO.PlaylistDTO;
import com.example.music.Entity.Playlist;
import com.example.music.Exception.NotFoundException;
import com.example.music.Repository.IPlaylistRepository;
import com.example.music.Service.IPlaylistService;
import com.example.music.Mapper.IPlaylistMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaylistService implements IPlaylistService {
    private final IPlaylistRepository iPlaylistRepository;
    private final IPlaylistMapper iPlaylistMapper;

    @Override
    public List<PlaylistDTO> findAllPlaylistDTO(String search) {
        List<PlaylistDTO> playlistDTOs = iPlaylistRepository.findPlaylistByNamePlaylistIsContaining(search).stream().map(iPlaylistMapper::playlistToPlaylistDTO).collect(Collectors.toList());
        return playlistDTOs;
    }

    @Override
    public Playlist findPlayListById(int id) {
        Playlist playlist = iPlaylistRepository.findById(id).orElse(null);
        if (playlist == null){
            throw new NotFoundException(String.format("Not found request application by id %d", id));
        }
        return playlist;
    }

    @Override
    public void addPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = iPlaylistMapper.playListDTOToPlayList(playlistDTO);
        iPlaylistRepository.save(playlist);
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        iPlaylistRepository.delete(playlist);
    }
}
